package org.shinar.neutral.representation.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class For implements Statement {
    @Setter(AccessLevel.PROTECTED)
    protected List<Expression> initializers = new ArrayList<Expression>();
    @Setter(AccessLevel.PROTECTED)
    protected List<Expression> updaters = new ArrayList<Expression>();
    protected Expression condition = null;
    protected CodeBlock block = null;

}
