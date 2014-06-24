package org.shinar.neutral.representation.statement;

import lombok.Data;
import org.shinar.neutral.representation.expression.Expression;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class While implements Statement {
    protected Expression condition;
    protected Statement block;
}
