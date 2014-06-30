package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class TypeReference implements ITypeReference{
    @Override
    public IType getType() {
        return null;
    }

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public int arrayDimensions() {
        return 0;
    }

    @Override
    public IContext getContext() {
        return null;
    }

    @Override
    public Iterable<IGenericArgument> getGenericArguments() {
        return null;
    }

    @Override
    public boolean hasGenericArguments() {
        return false;
    }
}
