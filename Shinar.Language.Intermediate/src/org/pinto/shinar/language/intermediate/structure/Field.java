package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.structure.IElementVisitor;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IField;
import org.pinto.shinar.language.core.structure.IFlag;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Field implements IField {
    private TypeReference type;
    private IExpression defaultValue;
    private Context context;
    private String name;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IFlag> flags = new ArrayList<IFlag>();

    @Override
    public boolean containsFlag(IFlag flag) {
        return flags.contains(flag);
    }

    @Override
    public <T> T visit(IElementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
