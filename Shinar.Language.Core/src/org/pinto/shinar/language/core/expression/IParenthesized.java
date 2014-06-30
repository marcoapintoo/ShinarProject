package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IWithContext;

/**
 * Created by marco on 29/06/14.
 */
public interface IParenthesized extends IExpression, IWithContext {
    IExpression getExpression();
}
