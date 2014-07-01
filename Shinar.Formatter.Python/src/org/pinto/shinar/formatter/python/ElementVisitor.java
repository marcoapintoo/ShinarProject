package org.pinto.shinar.formatter.python;

import lombok.Data;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.pinto.shinar.language.core.expression.IMethodParameterDeclaration;
import org.pinto.shinar.language.core.structure.IEnumField;
import org.pinto.shinar.language.core.structure.IField;
import org.pinto.shinar.language.core.structure.IMethod;
import org.pinto.shinar.language.core.visitor.ElementBaseVisitor;
import org.pinto.shinar.utils.IOutputWriter;

/**
 * Created by marco on 30/06/14.
 */
@Data
@ExtensionMethod({StringUtils.class, org.pinto.shinar.utils.StringUtils.class})
public class ElementVisitor extends ElementBaseVisitor<StackVisitor> {

    private void popStack() {
        getStack().pop();
    }

    private void pushStack(Object expression) {
        getStack().push(new StackVisitor(this, expression, getOutputWriter()));
    }

    private IOutputWriter getOutputWriter() {
        return getStack().peek().getOutputWriter();
    }

    @Override
    public String visit(IField element) {
        pushStack(element);
        getOutputWriter().append(element.getName()).append(" = ").append(element.getDefaultValue() == null ? "None" : element.getDefaultValue().visit(getExpressionVisitor()));
        popStack();
        return "";
    }

    @Override
    public String visit(IMethod element) {
        pushStack(element);
        getOutputWriter().append("def ").append(element.getName()).append("(self, ");
        for (IMethodParameterDeclaration declaration : element.getParameters()) {
            getOutputWriter().append(declaration.getName());
            if (declaration.getDefaultValue() != null) {
                getOutputWriter().append(" = ").append(declaration.getDefaultValue().visit(getExpressionVisitor()));
            }
            getOutputWriter().newline();
        }
        getOutputWriter().append("): ").newlineindented().append(element.getBlock().visit(getStatementVisitor())).newlineunindented();
        popStack();
        return "";
    }

    @Override
    public String visit(IEnumField element) {
        pushStack(element);
        getOutputWriter().append(element.getName()).append(" = None");
        popStack();
        return "";
    }
}
