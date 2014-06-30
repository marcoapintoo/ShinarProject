package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Namespace;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class This implements IThis{
    private Namespace namespace;
    private Context context;
}