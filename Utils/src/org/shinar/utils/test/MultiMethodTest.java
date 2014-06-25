package org.shinar.utils.test;

import org.shinar.utils.InfiniteRecursionWarning;
import org.shinar.utils.MultiMethod;

import java.util.ArrayList;

/**
 * Created by marco on 24/06/14.
 */
public class MultiMethodTest {

    @MultiMethod
    static String multimethodEmptyCall(Object arg) throws InfiniteRecursionWarning {
        return (String) MultiMethod.Apply.invokeStatic(arg);
    }

    @MultiMethod
    static String multimethodCall(Object arg) {
        String s = "O:" + arg + "|";
        try {
            return s + MultiMethod.Apply.invokeStatic(arg);
        } catch (InfiniteRecursionWarning e) {
            return "+";
        }
    }

    static String multimethodCall(Number arg) {
        return "N:" + arg;
    }

    static String multimethodCall(Integer arg) {
        return "I:" + arg;
    }

    static String multimethodCall(String arg) {
        return "S:" + arg;
    }

    @org.junit.Test
    public void testRedispatchStatic() throws Exception {
        org.junit.Assert.assertEquals(multimethodCall((Object) "1"), "O:1|S:1");
    }

    @org.junit.Test
    public void testDefaultRedispatchStatic() throws Exception {
        org.junit.Assert.assertEquals(multimethodCall(new Object()), "+");
    }

    @org.junit.Test
    public void testSubChildRedispatchStatic() throws Exception {
        org.junit.Assert.assertEquals(multimethodCall(1.2), "N:1.2");
    }

    @org.junit.Test(expected = InfiniteRecursionWarning.class)
    public void testFailRedispatchStatic() throws Exception {
        multimethodEmptyCall(new ArrayList<Integer>());
    }

    @org.junit.Test
    public void testRedispatch() throws Exception {

    }
}
