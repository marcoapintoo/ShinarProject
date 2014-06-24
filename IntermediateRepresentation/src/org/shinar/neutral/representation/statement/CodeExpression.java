package org.shinar.neutral.representation.statement;

import lombok.Data;
import org.shinar.neutral.representation.expression.Expression;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class CodeExpression implements Statement {
    protected Expression expression;
}
