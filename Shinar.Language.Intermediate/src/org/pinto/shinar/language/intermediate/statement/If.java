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
public class If implements IIf{
    private Expression condition;
    private IStatement trueAction;
    private IStatement falseAction;
    private Context context;
}
