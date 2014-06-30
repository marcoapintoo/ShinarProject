package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Namespace implements INamespace{
    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public INamespace getRoot() {
        return null;
    }

    @Override
    public Iterable<IType> getTypes() {
        return null;
    }

    @Override
    public boolean containsType(IType type) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
