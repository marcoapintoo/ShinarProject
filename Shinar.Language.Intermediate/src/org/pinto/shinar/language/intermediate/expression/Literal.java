package org.pinto.shinar.language.intermediate.expression;

import lombok.Data;
import org.pinto.shinar.language.core.expression.AbstractExpression;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.expression.ILiteral;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Literal<T> extends AbstractExpression implements ILiteral<T> {
    private T value;
    private Context context;

    @Override
    public <V> V visit(IExpressionVisitor<V> visitor) {
        return visitor.visit(this);
    }
}
