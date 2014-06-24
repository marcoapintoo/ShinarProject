package org.shinar.neutral.representation;

import lombok.Data;
import org.shinar.neutral.representation.expression.Expression;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class Field extends NeutralObject{
    private NeutralCodeUnit type;
    private Expression defaultExpression;
}
