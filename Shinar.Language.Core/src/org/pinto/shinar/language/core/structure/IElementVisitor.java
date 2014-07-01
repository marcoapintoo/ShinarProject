package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 30/06/14.
 */
public interface IElementVisitor<T> {
    T visit(IField element);

    T visit(IMethod element);

    T visit(IEnumField element);
}
