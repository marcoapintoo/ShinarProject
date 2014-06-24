package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Conditional implements Expression {
    protected Expression condition;
    protected Expression trueExpression;
    protected Expression falseExpression;
}
