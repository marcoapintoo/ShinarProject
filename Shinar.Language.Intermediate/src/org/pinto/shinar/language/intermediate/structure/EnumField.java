package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

import java.util.Iterator;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class EnumField implements IEnumField{
    @Override
    public Iterator<IExpression> getArguments() {
        return null;
    }

    @Override
    public boolean hasArguments() {
        return false;
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
