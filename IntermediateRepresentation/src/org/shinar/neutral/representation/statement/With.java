package org.shinar.neutral.representation.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 22/06/14.
 */
@Data
public class With implements Statement {
    protected CodeBlock block;
    @Setter(AccessLevel.PROTECTED)
    List<Expression> resources = new ArrayList<Expression>();
}
