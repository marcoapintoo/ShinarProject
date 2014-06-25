package org.shinar.adapter.java.analyzer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.shinar.neutral.representation.Directory;
import org.shinar.neutral.representation.Import;
import org.shinar.neutral.representation.NeutralCodeUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class CompilationUnitAnalyzer implements Analyzer<List<NeutralCodeUnit>> {
    protected CompilationUnit compilationUnit;
    @Setter(AccessLevel.PROTECTED)
    protected Directory directory = new Directory();
    @Setter(AccessLevel.PROTECTED)
    protected List<Import> imports = new ArrayList<Import>();
    @Setter(AccessLevel.PROTECTED)
    protected List<NeutralCodeUnit> representation = new ArrayList<NeutralCodeUnit>();

    protected CompilationUnitAnalyzer() {
    }

    @Override
    public void obtainInformation() {
        obtainPackage();
        obtainImports();
        obtainTypes();
    }

    protected void obtainPackage() {
        PackageDeclaration packageDeclaration = compilationUnit.getPackage();
        if (packageDeclaration != null) {
            directory = Directory.of(packageDeclaration.getName().toString());
        }
    }

    protected void obtainImports() {
        for (ImportDeclaration declaration : (List<ImportDeclaration>) compilationUnit.imports()) {
            String name = declaration.getName().toString();
            imports.add(Import.of(name, declaration.isOnDemand()));
        }
    }

    protected void obtainTypes() {
        for (AbstractTypeDeclaration type : (List<AbstractTypeDeclaration>) compilationUnit.types()) {
            representation.add(TypeAnalyzer.analyze(type));
        }
    }

    public static List<NeutralCodeUnit> analyze(CompilationUnit unit) {
        CompilationUnitAnalyzer target = new CompilationUnitAnalyzer();
        target.setCompilationUnit(unit);
        target.obtainInformation();
        return target.getRepresentation();
    }
}
