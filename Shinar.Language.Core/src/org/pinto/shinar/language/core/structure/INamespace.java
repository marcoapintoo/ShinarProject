package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 28/06/14.
 */
public interface INamespace extends IStructureFragment, IWithName {
    String getFullName();

    INamespace getRoot();

    Iterable<IType> getTypes();

    boolean containsType(IType type);
}
