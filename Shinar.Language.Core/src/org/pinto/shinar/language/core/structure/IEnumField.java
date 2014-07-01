package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 29/06/14.
 */
public interface IEnumField extends IElement, IWithName, IWithContext {
    Iterable<IExpression> getArguments();

    boolean hasArguments();
}

