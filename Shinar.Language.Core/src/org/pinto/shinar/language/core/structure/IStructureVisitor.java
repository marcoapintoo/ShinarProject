package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 30/06/14.
 */
public interface IStructureVisitor<T> {
    T visit(IClass structure);

    T visit(IInterface structure);

    T visit(IEnumeration structure);
}
