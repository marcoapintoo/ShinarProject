package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IInterface;
import org.pinto.shinar.language.core.structure.IStructureVisitor;
import org.pinto.shinar.language.core.structure.IType;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Interface extends Type implements IInterface {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IType> implementations = new ArrayList<IType>();

    @Override
    public boolean hasImplementations() {
        return implementations.size() == 0;
    }

    @Override
    public <T> T visit(IStructureVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
