package org.pinto.shinar.language.intermediate.expression;

import lombok.Data;
import org.pinto.shinar.language.core.expression.AbstractExpression;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.expression.IMethodCall;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IGenericArgument;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class MethodCall extends AbstractExpression implements IMethodCall {
    private String methodName;
    private IExpression expression;
    private ArrayList<IExpression> arguments;
    private ArrayList<IGenericArgument> genericArguments;
    private Context context;

    @Override
    public boolean hasGenericArguments() {
        return false;
    }

    @Override
    public <T> T visit(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
