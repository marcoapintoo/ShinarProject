package org.pinto.shinar.language.intermediate.expression;

import lombok.Data;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.expression.ISuperMethodCall;
import org.pinto.shinar.language.intermediate.structure.Namespace;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class SuperMethodCall extends MethodCall implements ISuperMethodCall {
    private Namespace namespace;

    @Override
    public <T> T visit(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
