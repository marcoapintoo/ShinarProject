package org.pinto.shinar.language.core;

/**
 * Created by marco on 28/06/14.
 */
public interface IGenericParameter {
    String getName();
    boolean isWildcard();
    boolean isInstantiable();

    Iterable<IType> getChildRequests();
    boolean hasChildRequests();

    Iterable<IType> getParentRequests();
    boolean hasParentRequests();
}
