package org.shinar.adapter.java;

import lombok.Data;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
import org.shinar.adapter.java.analyzer.CompilationUnitAnalyzer;
import org.shinar.adapter.neutral.BaseAdapter;
import org.shinar.formatter.nimrod.NimrodFormatter;
import org.shinar.neutral.representation.CodeGroup;
import org.shinar.neutral.representation.NeutralClass;
import org.shinar.neutral.representation.NeutralCodeUnit;

import java.util.List;
import java.util.Map;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class JavaAdapter extends BaseAdapter {

    private Document document;

    private CompilationUnit getAST(String code) {
        document = new Document(code);
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        Map options = JavaCore.getOptions();
        options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
        parser.setCompilerOptions(options);
        parser.setSource(document.get().toCharArray());
        return (CompilationUnit) parser.createAST(null);
    }

    @Override
    public CodeGroup parseString(String code) {
        CodeGroup group = new CodeGroup();
        group.getUnits().addAll(CompilationUnitAnalyzer.analyze(getAST(code)));
        return group;
    }

    private CompilationUnit compilationUnit;

    public void parse() {
        String code = "package org.uno; import java.util.List;import java.io.Serializable;\n" +
                "interface Foo{} \n" +
                "\nabstract class X implements Foo, Foo2<String>, Serializable, Foo2< Foo2< Foo2<String> > >\n{\n\n" +
                "\t//private int[] e;\n" +
                "\t//private int[] e1={1,2,3,4};\n" +
                "\t//private int[] e2=new int[]{1,2,3,4};\n" +
                "\tpublic int ba1,ba2;\n" +
                "\tpublic int ba=1;\n" +
                "\tpublic void deleteme(){\n" +
                "int i=0;\t" +
                "i++;\t" +
                "i = i*10;\t" +
                "if(i%2==0){System.out.print(\"Par!\");}else{System.out.println(i+\" \");}\t" +
                "}\n\n" +
                "}\n\n" +
                "interface Foo2<T extends Object & Serializable> {} \n" +
                "interface Foo3 extends Foo2<String>, Foo {} \n" +
                "enum Example{Data1, Data2, Data3}\n" +
                "protected class Y extends X{}\n" +
                "interface Other{public String methodName(); }";
        Document document = new Document(code);
        System.out.println(code);
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        Map options = JavaCore.getOptions();
        options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
        parser.setCompilerOptions(options);
        parser.setSource(document.get().toCharArray());
        compilationUnit = (CompilationUnit) parser.createAST(null);
        NimrodFormatter codeFormatter = new NimrodFormatter();
        List<NeutralCodeUnit> units = CompilationUnitAnalyzer.analyze(compilationUnit);
        NeutralClass klazz = (NeutralClass) units.get(1);
        System.out.println(codeFormatter.format(klazz));
        int i = 0;
    }

    private void obtainPackage() {
    }

    private void obtainImports() {

    }

    private void obtainTypes() {
    }

}
