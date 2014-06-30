package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;

/**
 * Created by marco on 29/06/14.
 */
public interface IReturn extends IStatement {
    IExpression getReturnValue();

    boolean hasReturnValue();
}
