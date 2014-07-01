package org.pinto.shinar.language.intermediate.expression;

import lombok.Data;
import org.pinto.shinar.language.core.expression.AbstractExpression;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.expression.IPostfixOperation;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class PostfixOperation extends AbstractExpression implements IPostfixOperation {
    private Operator operator;

    private IExpression operand;
    private Context context;

    @Override
    public <T> T visit(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
