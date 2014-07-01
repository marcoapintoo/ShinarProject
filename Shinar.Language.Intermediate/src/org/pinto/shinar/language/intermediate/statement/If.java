package org.pinto.shinar.language.intermediate.statement;

import lombok.Data;
import org.pinto.shinar.language.core.statement.IIf;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class If implements IIf {
    private IExpression condition;
    private IStatement trueAction;
    private IStatement falseAction;
    private Context context;

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
