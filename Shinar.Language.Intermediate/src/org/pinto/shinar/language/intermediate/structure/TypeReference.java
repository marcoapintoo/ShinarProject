package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IGenericArgument;
import org.pinto.shinar.language.core.structure.IStructureFragmentVisitor;
import org.pinto.shinar.language.core.structure.ITypeReference;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class TypeReference implements ITypeReference {
    private Type type;
    private Context context;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IGenericArgument> genericArguments = new ArrayList<IGenericArgument>();

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
    public boolean hasGenericArguments() {
        return genericArguments.size() == 0;
    }

    @Override
    public <T> T visit(IStructureFragmentVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
