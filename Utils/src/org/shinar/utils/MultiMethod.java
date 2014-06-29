package org.shinar.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by marco on 21/06/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultiMethod {
    //String target();

    public static class Apply {
        private static Map<Object[], Method> cache = new HashMap<Object[], Method>();
        private static Map<Object[], Object> cacheReturnValues = new HashMap<Object[], Object>();

        private static Class<?> findClass(String className) {
            try {
                return Class.forName(className);
            } catch (Exception e) {
                return null;
            }
        }

        private static Method searchMethod(Class<?> klazz, String methodName, List<Object> returnValues, Class<?>... types) {
            Method method = null;
            //TODO: Do not work for varargs
            ArrayList<Method> methods = new ArrayList<Method>();
            Object[] key = ArrayUtils.addAll(ArrayUtils.toArray(klazz, methodName), types);
            returnValues.add(null);
            if (cache.containsKey(key)) {
                returnValues.set(0, cacheReturnValues.get(key));
                return cache.get(key);
            }

            int identicalIndex = -1, j = 0;
            Method baseMultimethod = null;
            for (Method m : klazz.getDeclaredMethods()) {
                Class<?>[] definedTypes = m.getParameterTypes();
                if (m.getName().equals(methodName) && types.length == definedTypes.length) {
                    boolean valid = true, equal = true;
                    for (int i = 0; i < definedTypes.length; i++) {
                        equal &= definedTypes[i] == types[i];
                        if (!definedTypes[i].isAssignableFrom(types[i])) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) continue;
                    if (m.isAnnotationPresent(MultiMethod.class)) {
                        baseMultimethod = m;
                        continue;
                    }
                    methods.add(m);
                    if (equal) {
                        identicalIndex = j;
                        break;
                    }
                    j++;
                }
            }
            int size = methods.size();
            if (size == 0) {
                try {
                    returnValues.set(0, baseMultimethod == null ? null : baseMultimethod.getReturnType().newInstance());
                } catch (Exception e) {
                }
            } else if (size == 1 && identicalIndex < 0) {
                try {
                    //returnValues.set(0, methods.get(0).getReturnType().newInstance());
                    method = methods.get(0);
                } catch (Exception e) {
                }
            } else {
                int index = identicalIndex >= 0 ? identicalIndex : size - 2;
                method = methods.get(index);
            }
            cache.put(key, method);
            cacheReturnValues.put(key, returnValues.get(0));
            return method;
        }

        private static Object invokeMethod(Class<?> klazz, String methodName, Object object, List<Object> returnValues, Object... args) throws InfiniteRecursionWarning {
            Class<?>[] classes = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i]==null? Objects.class: args[i].getClass();
            }
            Method method = searchMethod(klazz, methodName, returnValues, classes);
            if (method == null) {
                throw new InfiniteRecursionWarning(klazz.toString() + "->" + methodName + ": Method is calling itself!");
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            try {
                returnValues.set(0, method.invoke(object, args));
            } catch (IllegalAccessException e) {
                throw new InfiniteRecursionWarning(klazz.toString() + "->" + methodName + ": Illegal access!", e);
            } catch (InvocationTargetException e) {
                Throwable cause;
                for(cause = e.getCause(); cause instanceof RuntimeException; cause = cause.getCause());
                throw new InfiniteRecursionWarning(klazz.toString() + "->" + methodName + ": Invocation target wrong!", cause);
                //throw new InfiniteRecursionWarning(klazz.toString() + "->" + methodName + ": Invocation target wrong!", e.getTargetException());
            }
            //throw new InfiniteRecursionWarning();
            return returnValues.get(0);
        }

        public static Object _invoke(int stackTraceIndex, List<Object> returnValues, Object object, Object... args) throws InfiniteRecursionWarning {
            final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
            final StackTraceElement targetMethod = trace[stackTraceIndex];
            return invokeMethod(findClass(targetMethod.getClassName()),
                    targetMethod.getMethodName(), object, returnValues, args);
        }

        public static Object invoke(Object object, Object... args) throws InfiniteRecursionWarning {
            return _invoke(2 + 1, new ArrayList<Object>(), object, args);
        }

        public static Object invokeStatic(Object... args) throws InfiniteRecursionWarning {
            return _invoke(2 + 1, new ArrayList<Object>(), null, args);
        }


        public static Object call(Object object, Object... args) {
            final List<Object> returnValues = new ArrayList<Object>();
            try {
                return _invoke(2 + 1, returnValues, object, args);
            } catch (InfiniteRecursionWarning infiniteRecursionWarning) {
            }
            return returnValues.get(0);
        }

        public static Object callStatic(Object... args) {
            final List<Object> returnValues = new ArrayList<Object>();
            try {
                return _invoke(2 + 1, returnValues, null, args);
            } catch (InfiniteRecursionWarning infiniteRecursionWarning) {
            }
            return returnValues.get(0);
        }
    }
}

