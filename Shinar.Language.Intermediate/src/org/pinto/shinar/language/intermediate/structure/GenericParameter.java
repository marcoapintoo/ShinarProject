package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class GenericParameter implements IGenericParameter{
    @Override
    public boolean isInstantiable() {
        return false;
    }

    @Override
    public Iterable<IType> getChildRequests() {
        return null;
    }

    @Override
    public boolean hasChildRequests() {
        return false;
    }

    @Override
    public Iterable<IType> getParentRequests() {
        return null;
    }

    @Override
    public boolean hasParentRequests() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
