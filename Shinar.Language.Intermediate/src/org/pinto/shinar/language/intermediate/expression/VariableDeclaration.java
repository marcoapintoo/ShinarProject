package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IFlag;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;
import org.pinto.shinar.language.intermediate.structure.TypeReference;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class VariableDeclaration implements IVariableDeclaration{
    private IExpression defaultValue;
    private TypeReference type;
    private String name;
    private Context context;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IFlag> flags = new ArrayList<IFlag>();

    public boolean containsFlag(IFlag flag){
        return false;
    }
}
