package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.statement.IStatementVisitor;

/**
 * Created by marco on 29/06/14.
 */
public interface IStatement extends IWithContext {
    <T> T visit(IStatementVisitor<T> visitor);
}
