package org.shinar.adapter.java.analyzer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.eclipse.jdt.core.dom.*;
import org.shinar.neutral.representation.*;
import org.shinar.utils.MultiMethod;
import org.shinar.utils.NoDispatchedMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class CodeUnitAnalyzer<T extends NeutralCodeUnit, V extends AbstractTypeDeclaration>  implements Analyzer<T> {
    protected V codeType;
    @Setter(AccessLevel.PROTECTED)
    protected T representation;

    @Override
    public void obtainInformation() {
        obtainName();
        obtainModifiersData();
        /*obtainInstantiation();
        obtainAccess();
        obtainVisibility();*/
        obtainParent();
        obtainInterfaces();
        obtainGenericParameters();
        obtainFields();
        obtainMethods();
    }

    protected void obtainName() {
        representation.setName(codeType.getName().toString());
    }

    protected void obtainModifiersData() {
        obtainModifiersData(representation, (List<Modifier>) codeType.modifiers());
    }
    public static <T extends NeutralObject> void obtainModifiersData(T representation, List<Modifier> modifiers){
        representation.getAccess().clear();
        representation.setInstantiation(ObjectInstantiation.Instance);
        representation.setVisibility(ObjectVisibility.Package);
        for (Modifier modifier : modifiers) {
            if (modifier.getKeyword() == Modifier.ModifierKeyword.FINAL_KEYWORD) {
                representation.getAccess().add(ObjectAccess.Final);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.NATIVE_KEYWORD) {
                representation.getAccess().add(ObjectAccess.Native);
            }else if (modifier.getKeyword() == Modifier.ModifierKeyword.STATIC_KEYWORD) {
                representation.setInstantiation(ObjectInstantiation.Static);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.ABSTRACT_KEYWORD) {
                representation.setInstantiation(ObjectInstantiation.AbstractInstance);
            }else if (modifier.getKeyword() == Modifier.ModifierKeyword.PUBLIC_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Public);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.PRIVATE_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Private);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.PROTECTED_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Protected);
            }
        }
        if (representation.getAccess().size() == 0) {
            representation.getAccess().add(ObjectAccess.Default);
        }
    }
    /*
    protected void obtainAccess() {
        obtainAccess(representation, (List<Modifier>) codeType.modifiers());
    }

    public static <T extends NeutralObject> void obtainAccess(T representation, List<Modifier> modifiers){
        representation.getAccess().clear();
        for (Modifier modifier : modifiers) {
            if (modifier.getKeyword() == Modifier.ModifierKeyword.FINAL_KEYWORD) {
                representation.getAccess().add(ObjectAccess.Final);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.NATIVE_KEYWORD) {
                representation.getAccess().add(ObjectAccess.Native);
            }
        }
        if (representation.getAccess().size() == 0) {
            representation.getAccess().add(ObjectAccess.Default);
        }
    }

    protected void obtainInstantiation() {
        obtainInstantiation(representation, (List<Modifier>) codeType.modifiers());
    }

    public static <T extends NeutralObject> void obtainInstantiation(T representation, List<Modifier> modifiers){
        representation.setInstantiation(ObjectInstantiation.Instance);
        for (Modifier modifier : modifiers) {
            if (modifier.getKeyword() == Modifier.ModifierKeyword.STATIC_KEYWORD) {
                representation.setInstantiation(ObjectInstantiation.Static);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.ABSTRACT_KEYWORD) {
                representation.setInstantiation(ObjectInstantiation.AbstractInstance);
            }
        }
    }

    protected void obtainVisibility() {
        obtainVisibility(representation, (List<Modifier>) codeType.modifiers());
    }

    public static <T extends NeutralObject> void obtainVisibility(T representation, List<Modifier> modifiers){
        representation.setVisibility(ObjectVisibility.Package);
        for (Modifier modifier : modifiers) {
            if (modifier.getKeyword() == Modifier.ModifierKeyword.PUBLIC_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Public);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.PRIVATE_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Private);
            } else if (modifier.getKeyword() == Modifier.ModifierKeyword.PROTECTED_KEYWORD) {
                representation.setVisibility(ObjectVisibility.Protected);
            }
        }
    }
    */

    protected void obtainParent() {
        //TODO: Do more OO
        if(codeType instanceof TypeDeclaration) {
            Type parent = ((TypeDeclaration)codeType).getSuperclassType();
            if (parent != null) {
                representation.getParents().add(classTypeData(parent));
                return;
            }
        }
        //TODO: References to
        representation.getParents().add(new NeutralCodeUnit());
    }

    protected void obtainInterfaces() {
        //TODO: Do more OO
        List<Type> interfaces = null;
        if(codeType instanceof TypeDeclaration) {
            interfaces = (List<Type>) ((TypeDeclaration) codeType).superInterfaceTypes();
        }else if(codeType instanceof EnumDeclaration){
            interfaces = (List<Type>) ((EnumDeclaration) codeType).superInterfaceTypes();
        }else{
            throw new RuntimeException("This is a valid declaration type? I will not handle that. Sorry :(");
        }
        for (Type interfaceDeclaration : interfaces) {
            representation.getImplementations().add(classTypeData(interfaceDeclaration));
        }
    }

    protected void obtainGenericParameters() {
        //TODO: Do more OO
        if(codeType instanceof TypeDeclaration) {
            obtainGenericParameters((List<TypeParameter>) ((TypeDeclaration)codeType).typeParameters(), representation.getTypeParameters());
        }
    }
    public static void obtainGenericParameters(List<TypeParameter> parameters, List<NeutralCodeUnit> typeParameters){
        //List<TypeParameter> parameters = (List<TypeParameter>) ((TypeDeclaration)codeType).typeParameters();
        if (parameters.size() != 0) {
            for (TypeParameter parameter : parameters) {
                NeutralCodeUnit genericParameter =classTypeData(parameter);
                for (Type typeDerived : (List<Type>) parameter.typeBounds()) {
                    genericParameter.getParents().add(classTypeData(typeDerived));
                }
                typeParameters.add(genericParameter);
            }
        }
    }


    protected void obtainFields() {
        //for(FieldDeclaration field :codeType.getFields())
        for(Object declaration: codeType.bodyDeclarations()){
            if(declaration instanceof FieldDeclaration){
                FieldDeclaration field = (FieldDeclaration) declaration;
                for(VariableDeclarationFragment varDeclaration: (List<VariableDeclarationFragment>)field.fragments()){
                    Field fieldRepresentation = new Field();
                    fieldRepresentation.setName(varDeclaration.getName().toString());
                    fieldRepresentation.setType(CodeUnitAnalyzer.classTypeData(field.getType()));
                    CodeUnitAnalyzer.obtainModifiersData(fieldRepresentation, (List<Modifier>) field.modifiers());
                    if(varDeclaration.getInitializer()!=null) {
                        fieldRepresentation.setDefaultExpression(ExpressionAnalyzer.analyze(varDeclaration.getInitializer()));
                    }
                    //Expression expression = varDeclaration.getInitializer();
                    //TODO: Is array!
                    representation.getFields().add(fieldRepresentation);
                }
            }
        }
    }

    protected void obtainMethods() {
        //for(MethodDeclaration method :codeType.getMethods())
        for(Object declaration: codeType.bodyDeclarations()){
            if(declaration instanceof MethodDeclaration){
                representation.getMethods().add(MethodAnalyzer.analyze((MethodDeclaration)declaration));
            }
        }
    }

    public static NeutralTypeDeclaration classTypeData(Type type) {
        try{
            return (NeutralTypeDeclaration) MultiMethod.redispatchStatic(type);
        }catch (NoDispatchedMethod e) {
            throw new RuntimeException("Wrong type!" + type.toString()+" " + type.getClass().toString());
        }
    }
    public static NeutralTypeDeclaration classTypeData(PrimitiveType type) {
        NeutralTypeDeclaration typeDeclaration = new NeutralTypeDeclaration();
        typeDeclaration.setName(type.getPrimitiveTypeCode().toString());
        typeDeclaration.setDirectory(Directory.of("java.lang"));
        //TODO: Is an array?
        typeDeclaration.setPrimitive(true);
        typeDeclaration.setDefinition(false);
        return typeDeclaration;
    }
    public static NeutralTypeDeclaration classTypeData(SimpleType type) {
        NeutralTypeDeclaration typeDeclaration = new NeutralTypeDeclaration();
        typeDeclaration.setName(type.getName().toString());
        //TODO: Add Package!... typeDeclaration.setNamespace
        //TODO: Is an array?
        typeDeclaration.setPrimitive(false);
        typeDeclaration.setDefinition(false);
        return typeDeclaration;
    }

    public static NeutralTypeDeclaration classTypeData(ParameterizedType type) {
        NeutralTypeDeclaration typeDeclaration = classTypeData(type.getType());
        for (Type innerTypeDeclaration : (List<Type>) type.typeArguments()) {
            typeDeclaration.getTypeParameters().add(classTypeData(innerTypeDeclaration));
        }
        return typeDeclaration;
    }

    public static NeutralTypeDeclaration classTypeData(TypeParameter type) {
        NeutralTypeDeclaration typeDeclaration = new NeutralTypeDeclaration();
        typeDeclaration.setName(type.getName().toString());
        //TODO: Add Package!... typeDeclaration.setNamespace
        typeDeclaration.setPrimitive(false);
        typeDeclaration.setDefinition(true);
        for (Type innerTypeDeclaration : (List<Type>) type.typeBounds()) {
            //TODO: Differences between classes, interfaces or enums
            typeDeclaration.getImplementations().add(classTypeData(innerTypeDeclaration));
        }
        return typeDeclaration;
    }
}
