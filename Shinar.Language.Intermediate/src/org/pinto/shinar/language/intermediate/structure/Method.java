package org.pinto.shinar.language.intermediate.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.expression.IMethodParameterDeclaration;
import org.pinto.shinar.language.core.structure.IElementVisitor;
import org.pinto.shinar.language.core.structure.IFlag;
import org.pinto.shinar.language.core.structure.IGenericParameter;
import org.pinto.shinar.language.core.structure.IMethod;
import org.pinto.shinar.language.intermediate.statement.Block;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Method implements IMethod {
    private TypeReference returnType;
    private Block block;
    private String name;
    private Context context;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IMethodParameterDeclaration> parameters = new ArrayList<IMethodParameterDeclaration>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IFlag> flags = new ArrayList<IFlag>();
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IGenericParameter> generics = new ArrayList<IGenericParameter>();

    @Override
    public boolean containsFlag(IFlag flag) {
        return flags.contains(flag);
    }

    @Override
    public boolean hasParameters() {
        return parameters.size() == 0;
    }

    @Override
    public boolean hasGenerics() {
        return generics.size() == 0;
    }

    @Override
    public <T> T visit(IElementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
