package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class GenericArgument implements IGenericArgument{
    @Override
    public ITypeReference getType() {
        return null;
    }

    @Override
    public boolean isWildcard() {
        return false;
    }

    @Override
    public Iterable<ITypeReference> getChildRequests() {
        return null;
    }

    @Override
    public boolean hasChildRequests() {
        return false;
    }

    @Override
    public Iterable<ITypeReference> getParentRequests() {
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
