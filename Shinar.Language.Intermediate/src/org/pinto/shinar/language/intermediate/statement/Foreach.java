package org.pinto.shinar.language.intermediate.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.expression.IVariableDeclaration;
import org.pinto.shinar.language.core.statement.IForeach;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Foreach implements IForeach {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IVariableDeclaration> variables = new ArrayList<IVariableDeclaration>();
    private IExpression generator;
    private IStatement action;
    private Context context;

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
