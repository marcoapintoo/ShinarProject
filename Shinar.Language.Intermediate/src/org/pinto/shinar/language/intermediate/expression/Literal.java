package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Literal<T> implements ILiteral<T>{
    private T value;
    private Context context;
}
