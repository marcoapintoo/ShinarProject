package org.pinto.shinar.utils;

/**
 * Created by marco on 01/07/14.
 */
public interface IOutputWriter {
    IOutputWriter append(String object);

    IOutputWriter append(Object object);

    IOutputWriter newline();

    IOutputWriter indent();

    IOutputWriter newlineindented();

    IOutputWriter unindent();

    IOutputWriter newlineunindented();
}
