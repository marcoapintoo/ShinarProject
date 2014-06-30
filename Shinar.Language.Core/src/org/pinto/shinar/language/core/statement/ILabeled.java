package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IStatement;

/**
 * Created by marco on 29/06/14.
 */
public interface ILabeled extends IStatement {
    String getLabel();

    IBlock getBlock();
}
