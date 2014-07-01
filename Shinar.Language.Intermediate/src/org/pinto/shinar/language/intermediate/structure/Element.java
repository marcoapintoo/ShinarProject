package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IElement;
import org.pinto.shinar.language.core.structure.IFlag;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public abstract class Element implements IElement {
    private String name;
    private Context context;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IFlag> flags = new ArrayList<IFlag>();

    @Override
    public boolean containsFlag(IFlag flag) {
        return flags.contains(flag);
    }
}
