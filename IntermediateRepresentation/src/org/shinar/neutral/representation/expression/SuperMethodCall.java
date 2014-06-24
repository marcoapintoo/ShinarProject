package org.shinar.neutral.representation.expression;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.Directory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class SuperMethodCall {
    protected Directory namespace;
    protected String methodName;
    @Setter(AccessLevel.PROTECTED)
    List<Expression> arguments = new ArrayList<Expression>();
}
