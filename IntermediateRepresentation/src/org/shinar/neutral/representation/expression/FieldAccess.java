package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class FieldAccess implements Expression {
    protected Expression expression;
    protected String field;
}
