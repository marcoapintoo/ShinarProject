package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IWithContext;

/**
 * Created by marco on 29/06/14.
 */
public interface IPrefixOperation extends IExpression, IWithContext {
    public enum Operator {
        AutoIncrement,
        AutoDecrement,
        Plus,
        Minus,
        Complement,
        Not
    }

    Operator getOperator();

    IExpression getOperand();
}
