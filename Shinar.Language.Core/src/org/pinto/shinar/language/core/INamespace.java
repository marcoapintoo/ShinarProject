package org.pinto.shinar.language.core;

/**
 * Created by marco on 28/06/14.
 */
public interface INamespace {
    String getName();
    String getFullName();
    INamespace getRoot();

    Iterable<IType> getTypes();
    boolean hasType(IType type);
}
