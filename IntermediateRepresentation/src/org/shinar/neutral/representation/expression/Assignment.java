package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class Assignment implements Expression {
    public enum Operator {
        Assign,
        PlusAssign,
        MinusAssign,
        TimesAssign,
        DivideAssign,
        BinaryAndAssign,
        BinaryOrAssign,
        BinaryXorAssign,
        LeftShiftAssign,
        RemainderAssign,
        RightShiftAssign,
        TripleRightShiftAssign
    }
    protected Expression leftExpression;
    protected Operator operator;
    protected Expression rightExpression;
}
