package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IGenericParameter;
import org.pinto.shinar.language.core.structure.IStructureFragmentVisitor;
import org.pinto.shinar.language.core.structure.IType;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class GenericParameter implements IGenericParameter {

    private TypeReference type;
    private String name;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> childRequests = new ArrayList<IType>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> parentRequests = new ArrayList<IType>();

    @Override
    public boolean isInstantiable() {
        return false;
    }

    @Override
    public boolean hasChildRequests() {
        return childRequests.size() == 0;
    }

    @Override
    public boolean hasParentRequests() {
        return parentRequests.size() == 0;
    }

    @Override
    public <T> T visit(IStructureFragmentVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
