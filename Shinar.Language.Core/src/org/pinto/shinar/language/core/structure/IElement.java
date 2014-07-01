package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 28/06/14.
 */
public interface IElement extends IWithName, IWithFlags, IWithContext {
    <T> T visit(IElementVisitor<T> visitor);
}
