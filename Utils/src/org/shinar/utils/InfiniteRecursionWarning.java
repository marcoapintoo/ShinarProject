package org.shinar.utils;

/**
 * Created by marco on 21/06/14.
 */
public class InfiniteRecursionWarning extends Exception {
    public InfiniteRecursionWarning() {
        super();
    }

    public InfiniteRecursionWarning(String message) {
        super(message);
    }

    public InfiniteRecursionWarning(Exception e) {
        super(e);
    }
}
