package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Parenthesized implements Expression {
    protected Expression expression;
}
