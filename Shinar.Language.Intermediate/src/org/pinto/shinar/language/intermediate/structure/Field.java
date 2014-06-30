package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Field implements IField{
    @Override
    public ITypeReference getType() {
        return null;
    }

    @Override
    public IExpression getDefaultValue() {
        return null;
    }

    @Override
    public IContext getContext() {
        return null;
    }

    @Override
    public Iterable<IFlag> getFlags() {
        return null;
    }

    @Override
    public boolean containsFlag(IFlag flag) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
