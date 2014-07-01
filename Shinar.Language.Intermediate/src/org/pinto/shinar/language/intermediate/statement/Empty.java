package org.pinto.shinar.language.intermediate.statement;

import lombok.Data;
import org.pinto.shinar.language.core.statement.IEmpty;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Empty implements IEmpty {
    private Context context;

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
