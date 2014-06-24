package org.shinar.neutral.representation.expression;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class InfixOperation implements Expression {
    public enum Operator {
        Plus, // +
        Minus, // -
        Times, // *
        Divide, // /
        Remainder, // %

        LeftShift, // <<
        RightShift, // >>

        TripleLessThan, // <<<
        TripleGreaterShift, // >>> -> Default Unsigned shift XD

        Less, // <
        Greater, // >

        LessOrEquals, // <=
        GreaterOrEquals, // >=

        Equals, // ==
        NotEquals, // !=

        BinaryXor, // ^
        BinaryOr, // ||
        BinaryAnd, // &
        Or, // ||
        And // &&
    }

    protected Operator operator;
    protected Expression rightOperand;
    protected Expression leftOperand;
    @Setter(AccessLevel.PROTECTED)
    protected List<Expression> otherOperands = new ArrayList<Expression>();
}
