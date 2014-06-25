package org.shinar.adapter.java.analyzer;

import lombok.Data;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.shinar.neutral.representation.NeutralInterface;

/**
 * Created by marco on 20/06/14.
 */
@Data
//Only for semantics information
public class InterfaceAnalyzer extends CodeUnitAnalyzer<NeutralInterface, TypeDeclaration> {
    protected InterfaceAnalyzer() {
        representation = new NeutralInterface();
    }

    /*    @Override
        public void obtainInformation() {
            super.obtainInformation();
        }

        protected void obtainFields() {

        }

        protected void obtainMethods() {

        }
    */
    public static NeutralInterface analyzeInterface(TypeDeclaration type) {
        if (TypePool.pool().containsKey(type)) {
            return (NeutralInterface) TypePool.pool().get(type);
        }
        InterfaceAnalyzer target = new InterfaceAnalyzer();
        target.setCodeType(type);
        target.obtainInformation();
        TypePool.pool().put(type, target.getRepresentation());
        return target.getRepresentation();
    }
}
