package org.pinto.shinar.language.intermediate.statement;

import lombok.Data;
import org.pinto.shinar.language.core.statement.IBreak;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Break implements IBreak {
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
