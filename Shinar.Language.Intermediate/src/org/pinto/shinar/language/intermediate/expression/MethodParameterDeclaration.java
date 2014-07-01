package org.pinto.shinar.language.intermediate.expression;

import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.expression.IMethodParameterDeclaration;

/**
 * Created by marco on 30/06/14.
 */
public class MethodParameterDeclaration extends VariableDeclaration implements IMethodParameterDeclaration {
    @Override
    public boolean isVariadic() {
        return false;
    }

    @Override
    public <T> T visit(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
