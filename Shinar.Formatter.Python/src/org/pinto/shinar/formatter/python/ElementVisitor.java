package org.pinto.shinar.formatter.python;

import lombok.Data;
import org.pinto.shinar.language.core.expression.IMethodParameterDeclaration;
import org.pinto.shinar.language.core.structure.IEnumField;
import org.pinto.shinar.language.core.structure.IField;
import org.pinto.shinar.language.core.structure.IMethod;
import org.pinto.shinar.language.core.visitor.ElementBaseVisitor;
import org.pinto.shinar.utils.OutputString;
import org.pinto.shinar.utils.Tabulator;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class ElementVisitor extends ElementBaseVisitor {
    private Tabulator tabulator;

    @Override
    public String visit(IField element) {
        return new OutputString("@{name} = @{value}".template(
                "name", element.getName(),
                "value", element.getDefaultValue() == null ? "None" : element.getDefaultValue().visit(getExpressionVisitor())
        )).newLine().toString();
    }

    @Override
    public String visit(IMethod element) {
        OutputString builder = new OutputString(
                "def @name(self, ".template("name", element.getName()).build()
        );
        builder.setTabulator(tabulator);
        for (IMethodParameterDeclaration declaration : element.getParameters()) {
            builder.append(declaration.getName());
            if (declaration.getDefaultValue() != null) {
                builder.append(" = ", declaration.getDefaultValue().visit(getExpressionVisitor()));
            }
        }
        builder.append("):").newLine().indent();
        builder.append(element.getBlock().visit(getStatementVisitor()));
        builder.unindent().newLine();
        return builder.toString();
    }

    @Override
    public String visit(IEnumField element) {
        return "@{name} = None".template(
                "name", element.getName()
        );
    }
}
