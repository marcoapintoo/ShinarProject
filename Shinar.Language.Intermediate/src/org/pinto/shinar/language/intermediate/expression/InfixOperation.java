package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class InfixOperation implements IInfixOperation{
    private Operator operator;

    private IExpression leftOperand;

    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IExpression> rightOperands = new ArrayList<IExpression>();
    private Context context;
}
