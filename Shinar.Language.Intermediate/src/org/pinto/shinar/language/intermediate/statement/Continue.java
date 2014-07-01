package org.pinto.shinar.language.intermediate.statement;

import lombok.Data;
import org.pinto.shinar.language.core.statement.IContinue;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Continue implements IContinue {
    private String label;
    private Context context;

    @Override
    public boolean hasLabel() {
        return label != null && !label.equals("");
    }


    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
