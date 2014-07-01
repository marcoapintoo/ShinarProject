package org.pinto.multimethod;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class InfiniteRecursionWarning extends Exception {

    public InfiniteRecursionWarning() {
        super();
    }

    public InfiniteRecursionWarning(String message) {
        super(message);
    }

    public InfiniteRecursionWarning(String message, Throwable e) {
        super(message, e);
    }

    public InfiniteRecursionWarning(Exception e) {
        super(e);
    }
}
