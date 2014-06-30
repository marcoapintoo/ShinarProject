package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Expression implements IExpression{
    @Override
    public IContext getContext() {
        return null;
    }
}
