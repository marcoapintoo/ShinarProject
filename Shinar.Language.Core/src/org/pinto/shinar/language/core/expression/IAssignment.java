package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IWithContext;

/**
 * Created by marco on 29/06/14.
 */
public interface IAssignment extends IExpression, IWithContext {
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

    IExpression getLeftExpression();

    Operator getOperator();

    IExpression getRightExpression();
}
