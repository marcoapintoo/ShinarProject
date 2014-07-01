package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;

/**
 * Created by marco on 30/06/14.
 */
public abstract class AbstractExpression implements IExpression {
    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
