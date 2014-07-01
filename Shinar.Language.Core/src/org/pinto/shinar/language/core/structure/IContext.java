package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 29/06/14.
 */
public interface IContext {
    INamespace getCurrentNamespace();

    IType getCurrentType();
}
