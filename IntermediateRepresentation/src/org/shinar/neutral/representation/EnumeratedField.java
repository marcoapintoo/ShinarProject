package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 24/06/14.
 */
@Data
public class EnumeratedField extends Field {
    @Setter(AccessLevel.PROTECTED)
    List<Expression> arguments = new ArrayList<Expression>();
}
