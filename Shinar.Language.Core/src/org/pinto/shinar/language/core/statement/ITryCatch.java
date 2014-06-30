package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.core.expression.IVariableDeclaration;

/**
 * Created by marco on 29/06/14.
 */
public interface ITryCatch {
    Iterable<IVariableDeclaration> getErrors();

    IStatement getAction();
}
