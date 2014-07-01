package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 30/06/14.
 */
public interface IStructureFragment {
    <T> T visit(IStructureFragmentVisitor<T> visitor);
}
