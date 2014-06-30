package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Return implements IReturn{
    private Expression returnValue;
    private Context context;
    @Override
    public boolean hasReturnValue() {
        return returnValue != null && returnValue instanceof IEmpty;
    }
}
