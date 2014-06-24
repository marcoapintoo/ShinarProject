package org.shinar.adapter.java.analyzer;

import org.eclipse.jdt.core.dom.*;
import org.shinar.neutral.representation.*;

import java.util.List;

/**
 * Created by marco on 20/06/14.
 */
public class EnumAnalyzer extends CodeUnitAnalyzer<NeutralEnumeration, EnumDeclaration>{
    protected EnumAnalyzer(){
        representation = new NeutralEnumeration();
    }
    @Override
    public void obtainInformation() {
        /*obtainName();
        obtainParent();
        obtainInterfaces();
        obtainGenericParameters();*/
        super.obtainInformation();
        obtainEnumFields();
    }

    protected void obtainEnumFields() {
        for(EnumConstantDeclaration declaration: (List<EnumConstantDeclaration>)codeType.enumConstants()){
            EnumeratedField field = new EnumeratedField();
            CodeUnitAnalyzer.obtainModifiersData(field, (List<Modifier>) declaration.modifiers());
            field.setName(declaration.getName().toString());
            for(Expression expression: (List<Expression>)declaration.arguments()){
                field.getArguments().add(ExpressionAnalyzer.analyze(expression));
            }
            //TODO: Handle anonymous class
            //AnonymousClassDeclaration innerClass = declaration.getAnonymousClassDeclaration();
        }
    }


    public static NeutralEnumeration analyze(EnumDeclaration type) {
        if(TypePool.pool().containsKey(type)){return (NeutralEnumeration)TypePool.pool().get(type);}
        EnumAnalyzer target = new EnumAnalyzer();
        target.setCodeType(type);
        target.obtainInformation();
        TypePool.pool().put(type, target.getRepresentation());
        return target.getRepresentation();
    }
}

