package org.shinar.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by marco on 21/06/14.
 */
public class MultiMethod {
    private static Object redispatch(final StackTraceElement targetMethod, Object targetObject, Object... args) throws NoDispatchedMethod {
        try {
            Class<?>[] classes = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            final Method method = Class.forName(targetMethod.getClassName())
                    .getMethod(targetMethod.getMethodName(), classes);
            if (method != null) {
                return method.invoke(targetObject, args);
            }
        } catch (ClassNotFoundException e) {
            throw new NoDispatchedMethod(e);
        } catch (NoSuchMethodException e) {
            throw new NoDispatchedMethod(e);
        } catch (SecurityException e) {
            throw new NoDispatchedMethod(e);
        } catch (IllegalArgumentException e) {
            throw new NoDispatchedMethod(e);
        } catch (IllegalAccessException e) {
            throw new NoDispatchedMethod(e);
        } catch (InvocationTargetException e) {
            throw new NoDispatchedMethod(e);
        }
        throw new NoDispatchedMethod();
    }
    public static Object redispatch(Object targetObject, Object... args) throws NoDispatchedMethod {
        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        final StackTraceElement targetMethod = trace[2];
        /* Only for tests :D
        for(int i = 0; i < trace.length; i++) {
            StackTraceElement t = trace[i];
            System.out.print(i + ": ");
            System.out.print(t.getClassName());
            System.out.print(" ");
            System.out.println(t.getMethodName());
        }
        System.out.println(targetMethod.getClassName());
        System.out.println(targetMethod.getMethodName());
        */
        return redispatch(targetMethod, targetObject,args);
    }

    public static Object redispatchStatic(Object... args) throws NoDispatchedMethod {
        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        final StackTraceElement targetMethod = trace[2];
        return redispatch(targetMethod, null,args);
    }
}
