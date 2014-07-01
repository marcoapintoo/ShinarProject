package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 30/06/14.
 */
public interface IStructureFragmentVisitor<T> {
    T visit(ITypeReference element);

    T visit(INamespace element);

    T visit(IGenericArgument element);

    T visit(IGenericParameter element);
}
