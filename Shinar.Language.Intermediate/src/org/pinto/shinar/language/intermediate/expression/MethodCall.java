package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IGenericArgument;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class MethodCall implements IMethodCall{
    private String methodName;
    private IExpression expression;
    private ArrayList<IExpression> arguments;
    private ArrayList<IGenericArgument> genericArguments;
    private Context context;

    @Override
    public boolean hasGenericArguments() {
        return false;
    }
}
