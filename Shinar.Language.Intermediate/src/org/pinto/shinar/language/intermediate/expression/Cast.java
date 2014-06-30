package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.ITypeReference;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;
import org.pinto.shinar.language.intermediate.structure.TypeReference;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Cast implements ICast{
    private TypeReference targetType;
    private IExpression expression;
    private Context context;
}
