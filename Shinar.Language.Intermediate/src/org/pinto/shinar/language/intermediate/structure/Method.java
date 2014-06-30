package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.statement.IBlock;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Method implements IMethod{
    @Override
    public ITypeReference getReturnType() {
        return null;
    }

    @Override
    public Iterable<Object> getParameters() {
        return null;
    }

    @Override
    public boolean hasParameters() {
        return false;
    }

    @Override
    public IBlock getBlock() {
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
    public Iterable<IGenericParameter> getGenerics() {
        return null;
    }

    @Override
    public boolean hasGenerics() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
