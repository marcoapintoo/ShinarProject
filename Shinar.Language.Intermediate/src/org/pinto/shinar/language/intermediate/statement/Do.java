package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;
import org.pinto.shinar.language.intermediate.structure.Statement;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Do implements IDo{
    private Expression condition;
    private IStatement action;
    private Context context;
}
