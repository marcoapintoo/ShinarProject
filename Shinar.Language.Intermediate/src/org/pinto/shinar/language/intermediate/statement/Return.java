package org.pinto.shinar.language.intermediate.statement;

import lombok.Data;
import org.pinto.shinar.language.core.statement.IEmpty;
import org.pinto.shinar.language.core.statement.IReturn;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Return implements IReturn {
    private IExpression returnValue;
    private Context context;

    @Override
    public boolean hasReturnValue() {
        return returnValue != null && returnValue instanceof IEmpty;
    }


    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
