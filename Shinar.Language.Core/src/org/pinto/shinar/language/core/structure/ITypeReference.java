package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 29/06/14.
 */
public interface ITypeReference extends IStructureFragment, IWithGenericArguments, IWithContext {
    IType getType();

    boolean isGeneric();

    boolean isArray();

    int arrayDimensions(); //-1 if it's unknown

}