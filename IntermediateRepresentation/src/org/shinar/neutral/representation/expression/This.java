package org.shinar.neutral.representation.expression;

import lombok.Data;
import org.shinar.neutral.representation.Directory;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class This implements Expression {
    protected Directory namespace;
    public boolean isSimple(){
        return namespace == null;
    }

}
