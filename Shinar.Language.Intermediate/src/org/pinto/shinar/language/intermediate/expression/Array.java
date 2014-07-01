package org.pinto.shinar.language.intermediate.expression;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.expression.AbstractExpression;
import org.pinto.shinar.language.core.expression.IArray;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Array extends AbstractExpression implements IArray {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IExpression> elements = new ArrayList<IExpression>();
    private Context context = new Context();

    @Override
    public <T> T visit(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
