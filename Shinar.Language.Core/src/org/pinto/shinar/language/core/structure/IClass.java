package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 28/06/14.
 */
public interface IClass extends IType {

    //Parents are types from methodsd and fields are inherited
    Iterable<IType> getParents();

    boolean hasParents();

    //Implementations are types from methods signatures and fields (as final) are inherited. Its content aren't copied.
    Iterable<IType> getImplementations();

    boolean hasImplementations();
}
