package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 29/06/14.
 */
//new ArrayList<? extends List>();
public interface IGenericArgument extends IWithName {
    ITypeReference getType();

    boolean isWildcard();

    Iterable<ITypeReference> getChildRequests();

    boolean hasChildRequests();

    Iterable<ITypeReference> getParentRequests();

    boolean hasParentRequests();
}
