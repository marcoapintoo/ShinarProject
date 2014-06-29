package org.pinto.shinar.language.core;


/**
 * Created by marco on 28/06/14.
 */
public interface IType {
    Iterable<IFlag> getFlags();
    boolean hasFlag(IFlag flag);

    String getName();
    INamespace getNamespace();
    ISignature getSignature();

    //Parents are types from methodsd and fields are inherited
    Iterable<IType> getParents();
    boolean hasParents();

    //Implementations are types from methods signatures and fields (as final) are inherited. Its content aren't copied.
    Iterable<IType> getImplementations();
    boolean hasImplementations();

    Iterable<IGenericParameter> getGenerics();
    boolean hasGenerics();

    Iterable<IElement> getElements();
    boolean hasElements();

    IContext getContext();
}
