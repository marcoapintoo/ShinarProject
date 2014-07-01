package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.*;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Enumeration extends Type implements IEnumeration {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> parents = new ArrayList<IType>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> implementations = new ArrayList<IType>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IEnumField> values = new ArrayList<IEnumField>();

    @Override
    public boolean hasParents() {
        return parents.size() == 0;
    }

    @Override
    public boolean hasImplementations() {
        return implementations.size() == 0;
    }

    @Override
    public boolean hasValues() {
        return values.size() == 0;
    }

    @Override
    public ITypeReference getTypeReference(ITypeReference... genericArguments) {
        return null;
    }

    @Override
    public <T> T visit(IStructureVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
