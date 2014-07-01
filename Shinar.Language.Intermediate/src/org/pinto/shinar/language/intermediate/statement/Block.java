package org.pinto.shinar.language.intermediate.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.statement.IBlock;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Block implements IBlock {
    private Context context;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IStatement> statements = new ArrayList<IStatement>();

    @Override
    public boolean hasContent() {
        return statements.size() > 0;
    }

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
