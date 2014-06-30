package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 28/06/14.
 */
public interface IGenericParameter extends IWithName {
    //boolean isWildcard();
    boolean isInstantiable();

    Iterable<IType> getChildRequests();

    boolean hasChildRequests();

    Iterable<IType> getParentRequests();

    boolean hasParentRequests();
}
