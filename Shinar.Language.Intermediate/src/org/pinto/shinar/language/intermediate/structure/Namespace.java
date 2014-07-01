package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.INamespace;
import org.pinto.shinar.language.core.structure.IStructureFragmentVisitor;
import org.pinto.shinar.language.core.structure.IType;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Namespace implements INamespace {
    private String name;
    private Namespace root;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> types = new ArrayList<IType>();

    @Override
    public boolean containsType(IType type) {
        return types.contains(type);
    }

    @Override
    public String getFullName() {
        return root == null ? name : root.getFullName() + "." + name;
    }

    @Override
    public <T> T visit(IStructureFragmentVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
