package org.shinar.utils;

/**
 * Created by marco on 21/06/14.
 */
public class NoDispatchedMethod extends Exception {
    public NoDispatchedMethod(){
        super();
    }
    public NoDispatchedMethod(String message){
        super(message);
    }
    public NoDispatchedMethod(Exception e){
        super(e);
    }
}
