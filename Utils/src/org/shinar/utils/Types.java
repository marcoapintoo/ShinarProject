package org.shinar.utils;

/**
 * Created by marco on 25/06/14.
 */
public class Types {
    public static <T> T trycast(Class<T> klazz, Object o){
        return klazz.isInstance(o)? (T)o: null;
    }
}
