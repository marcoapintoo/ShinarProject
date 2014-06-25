package org.shinar.neutral.representation.expression;

import lombok.Data;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class NullLiteral extends Literal<Object> {
    @Override
    public void setValue(Object o) {

    }

    @Override
    public Object getValue() {
        return null;
    }
}
