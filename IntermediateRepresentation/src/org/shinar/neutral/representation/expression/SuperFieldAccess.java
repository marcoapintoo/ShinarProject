package org.shinar.neutral.representation.expression;

import lombok.Data;
import org.shinar.neutral.representation.Directory;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class SuperFieldAccess {
    protected Directory namespace;
    protected String field;
}
