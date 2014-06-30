package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 28/06/14.
 */
public interface IInterface extends IType {
    //Implementations are types from methods signatures and fields (as final) are inherited. Its content aren't copied.
    Iterable<IType> getImplementations();

    boolean hasImplementations();
}
