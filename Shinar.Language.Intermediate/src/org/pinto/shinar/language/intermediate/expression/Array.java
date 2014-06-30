package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Array implements IArray{
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IExpression> elements = new ArrayList<IExpression>();
    private Context context = new Context();
}
