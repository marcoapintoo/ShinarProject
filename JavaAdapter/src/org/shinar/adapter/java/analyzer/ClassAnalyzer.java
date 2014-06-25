package org.shinar.adapter.java.analyzer;

import lombok.Data;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.shinar.neutral.representation.NeutralClass;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class ClassAnalyzer extends CodeUnitAnalyzer<NeutralClass, TypeDeclaration> {

    protected ClassAnalyzer() {
        representation = new NeutralClass();
    }

    @Override
    public void obtainInformation() {
        /*obtainName();
        obtainParent();
        obtainInterfaces();
        obtainGenericParameters();
        */
        super.obtainInformation();
        obtainInnerClasses();
    }

    protected void obtainInnerClasses() {
    }

    public static NeutralClass analyze(TypeDeclaration type) {
        if (TypePool.pool().containsKey(type)) {
            return (NeutralClass) TypePool.pool().get(type);
        }
        ClassAnalyzer target = new ClassAnalyzer();
        target.setCodeType(type);
        target.obtainInformation();
        TypePool.pool().put(type, target.getRepresentation());
        return target.getRepresentation();
    }
}
