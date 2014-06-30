package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IWithContext;

/**
 * Created by marco on 29/06/14.
 */
public interface IInfixOperation extends IExpression, IWithContext {
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

    Operator getOperator();

    IExpression getLeftOperand();

    Iterable<IExpression> getRightOperands();
    //IExpression getRightOperand();
    //Iterable<IExpression> getOtherOperands();
}
