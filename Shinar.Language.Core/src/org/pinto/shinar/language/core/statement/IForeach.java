package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.core.expression.IVariableDeclaration;

/**
 * Created by marco on 29/06/14.
 */
public interface IForeach extends IStatement {
    Iterable<IVariableDeclaration> getVariables();

    IExpression getGenerator();

    IStatement getAction();
}
