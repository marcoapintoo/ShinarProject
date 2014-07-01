package org.pinto.shinar.language.intermediate.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.statement.IFor;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class For implements IFor {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IExpression> initializers = new ArrayList<IExpression>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IExpression> updaters = new ArrayList<IExpression>();
    private IExpression condition;
    private IStatement action;
    private Context context;

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
