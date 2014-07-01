package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IStatement;

/**
 * Created by marco on 29/06/14.
 */
public interface IBlock extends IStatement {
    Iterable<IStatement> getStatements();

    boolean hasContent();
}
