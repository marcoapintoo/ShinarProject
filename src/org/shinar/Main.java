package org.shinar;

import org.shinar.adapter.java.Adapter;
import org.shinar.utils.MultiMethod;
import org.shinar.utils.NoDispatchedMethod;

public class Main {
    class Generic2<T> {
        public String name;
        private String otherName;

        public Generic2(T a) {
            name = a.toString();
        }

        public void analysis(String str) {
            System.out.println(str);
        }

        public Generic2<T> self() {
            return this;
        }
    }

    static class Generic<T> {
        public String name;
        private String otherName;

        public Generic(T a) {
            name = a.toString();
        }

        public void analysis(String str) {
            System.out.println(str);
        }

        public Generic<T> self() {
            return this;
        }
    }

    static class A {
        public int num = 0;
    }

    static class B extends A {
    }

    static class C extends B {
    }

    //public static <V extends A> void example(V o) {
    public static void example(A o) {
        /*
        //http://stackoverflow.com/a/8571530
        */
        try {
            MultiMethod.redispatch(null, o);
        } catch (NoDispatchedMethod e) {
            System.out.println(o.getClass().toString() + "--1");
        }
        //example(o.getClass().cast(o));
    }


    public static void example(B o) {
        System.out.println(o.getClass().toString() + "--2");
    }

    public static void example(C o) {
        System.out.println(o.getClass().toString() + "--3");
    }

    public static void example1(A o) {
        System.out.println(o.getClass().toString() + "--=>A");
    }

    public static void example1(B o) {
        System.out.println(o.getClass().toString() + "--=>B");
    }

    public static <T extends A> void castExample(A o) {
        example1((T) o);
    }

    public static void main(String[] args) {
        /*Reflector reflector = new Reflector();
        //reflector.load("");
        reflector.traverseObject(new Generic(12));
        CodeFormatter formatter = new CodeFormatter();
        formatter.setReflector(reflector);
        Default o = new Generic(12).getClass();
        String s = formatter.formatClass(o);
        System.out.println(s);*/
        B b = new B();
        A a = (A) b;
        example(a);
        example(b);
        Main.<B>castExample(a);
        Adapter adapter = new Adapter();
        adapter.parse();
    }
}
