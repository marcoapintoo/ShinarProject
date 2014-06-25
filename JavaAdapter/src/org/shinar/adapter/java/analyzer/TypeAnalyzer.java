package org.shinar.adapter.java.analyzer;

import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.shinar.neutral.representation.NeutralCodeUnit;

/**
 * Created by marco on 22/06/14.
 */
public class TypeAnalyzer {

    protected static NeutralCodeUnit obtainClass(TypeDeclaration type) {
        return ClassAnalyzer.analyze(type);
    }

    protected static NeutralCodeUnit obtainInterface(TypeDeclaration type) {
        return InterfaceAnalyzer.analyzeInterface(type);
    }

    protected static NeutralCodeUnit obtainEnum(EnumDeclaration type) {
        //TODO: Enums!
        return EnumAnalyzer.analyze(type);
    }

    public static NeutralCodeUnit analyze(AbstractTypeDeclaration type) {
        if (type instanceof TypeDeclaration) {
            TypeDeclaration typeDeclaration = (TypeDeclaration) type;
            if (typeDeclaration.isInterface()) {
                return obtainInterface(typeDeclaration);
            } else {
                return obtainClass(typeDeclaration);
            }
        } else if (type instanceof EnumDeclaration) {
            return obtainEnum((EnumDeclaration) type);
        } else {
            throw new RuntimeException("What kind of type is that? I cannot handle this!");
        }
    }
}
