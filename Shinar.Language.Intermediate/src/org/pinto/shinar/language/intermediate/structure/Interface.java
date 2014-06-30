package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Interface implements IInterface{
    @Override
    public Iterable<IType> getImplementations() {
        return null;
    }

    @Override
    public boolean hasImplementations() {
        return false;
    }

    @Override
    public Iterable<IElement> getElements() {
        return null;
    }

    @Override
    public boolean hasElements() {
        return false;
    }

    @Override
    public ITypeReference getTypeReference(ITypeReference... genericArguments) {
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
