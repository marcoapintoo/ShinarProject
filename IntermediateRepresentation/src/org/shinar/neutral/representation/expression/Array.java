package org.shinar.neutral.representation.expression;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class Array implements Expression {
    @Setter(AccessLevel.PROTECTED)
    List<Expression> elements = new ArrayList<Expression>();
}
