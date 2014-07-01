package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IElement;
import org.pinto.shinar.language.core.structure.IFlag;
import org.pinto.shinar.language.core.structure.IType;
import org.pinto.shinar.language.core.structure.ITypeReference;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public abstract class Type implements IType {
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IElement> elements = new ArrayList<IElement>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IFlag> flags = new ArrayList<IFlag>();
    private Context context;
    private String name;

    @Override
    public boolean hasElements() {
        return elements.size() == 0;
    }

    @Override
    public ITypeReference getTypeReference(ITypeReference... genericArguments) {
        return null;
    }

    @Override
    public boolean containsFlag(IFlag flag) {
        return flags.contains(flag);
    }
}
