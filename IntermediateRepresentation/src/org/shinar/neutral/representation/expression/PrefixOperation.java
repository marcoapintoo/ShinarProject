package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class PrefixOperation implements Expression {
    public enum Operator {
        AutoIncrement,
        AutoDecrement,
        Plus,
        Minus,
        Complement,
        Not
    }

    protected Operator operator;
    protected Expression operand;
}
