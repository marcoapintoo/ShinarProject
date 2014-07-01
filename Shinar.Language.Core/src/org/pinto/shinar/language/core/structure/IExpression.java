package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.expression.IExpressionVisitor;

/**
 * Created by marco on 29/06/14.
 */
public interface IExpression extends IStatement {
    <T> T visit(IExpressionVisitor<T> visitor);
}
