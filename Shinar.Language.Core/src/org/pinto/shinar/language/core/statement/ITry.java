package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IStatement;

/**
 * Created by marco on 29/06/14.
 */
public interface ITry extends IStatement {
    IStatement getVerifiedAction();

    IStatement getFinallyAction();

    Iterable<ITryCatch> getCatchErrors();
}
