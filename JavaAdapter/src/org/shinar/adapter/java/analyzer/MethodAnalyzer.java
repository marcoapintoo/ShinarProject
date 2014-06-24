package org.shinar.adapter.java.analyzer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.Statement;
import org.shinar.neutral.representation.Method;
import org.shinar.neutral.representation.NeutralTypeDeclaration;
import org.shinar.neutral.representation.statement.*;
import org.shinar.neutral.representation.statement.VariableDeclaration;

import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class MethodAnalyzer implements Analyzer<Method> {
    protected MethodDeclaration codeType;
    @Setter(AccessLevel.PROTECTED)
    protected Method representation = new Method();

    protected MethodAnalyzer() {
    }

    @Override
    public void obtainInformation() {
        obtainName();
        obtainReturnType();
        obtainModifiersData();
        obtainParameters();
        obtainGenericParameters();
        obtainCode();
    }

    protected void obtainName() {
        if(codeType.isConstructor()){
            representation.setConstructor(true);
        }
        representation.setName(codeType.getName().toString());
    }

    protected void obtainReturnType() {
        if(codeType.getReturnType2()!=null) {
            representation.setReturnType(CodeUnitAnalyzer.classTypeData(codeType.getReturnType2()));
        }
    }

    protected void obtainModifiersData() {
        CodeUnitAnalyzer.obtainModifiersData(representation, (List<Modifier>) codeType.modifiers());
    }

    protected void obtainParameters() {
        for (SingleVariableDeclaration declaration : (List<SingleVariableDeclaration>) codeType.parameters()) {
            representation.getParameters().getVariables().add(StatementAnalyzer.analyze(declaration).getVariables().get(0));
        }
    }

    protected void obtainGenericParameters() {
        CodeUnitAnalyzer.obtainGenericParameters(codeType.typeParameters(), representation.getTypeParameters());
    }

    protected void obtainCode() {
        Block block = codeType.getBody();
        if(block==null) return;
        for(Statement statement: (List<Statement>)block.statements()){
            representation.getBlock().getStatements().add(StatementAnalyzer.analyze(statement));
        }
    }

    public static Method analyze(MethodDeclaration type) {
        MethodAnalyzer target = new MethodAnalyzer();
        target.setCodeType(type);
        target.obtainInformation();
        return target.getRepresentation();
    }
}
