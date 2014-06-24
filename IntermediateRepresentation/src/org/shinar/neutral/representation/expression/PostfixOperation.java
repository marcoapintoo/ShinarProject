package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class PostfixOperation implements Expression {
    public enum Operator{
        AutoDecrement,
        AutoIncrement
    }
    protected Operator operator;
    protected Expression operand;
}
