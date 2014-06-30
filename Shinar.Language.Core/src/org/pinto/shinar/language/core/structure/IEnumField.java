package org.pinto.shinar.language.core.structure;

import java.util.Iterator;

/**
 * Created by marco on 29/06/14.
 */
public interface IEnumField extends IElement, IWithName, IWithContext {
    Iterator<IExpression> getArguments();

    boolean hasArguments();
}

