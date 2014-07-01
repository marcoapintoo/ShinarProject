package org.pinto.shinar.formatter.python;

import org.pinto.shinar.language.core.structure.*;
import org.pinto.shinar.language.core.visitor.StructureBaseVisitor;
import org.pinto.shinar.utils.IOutputWriter;

/**
 * Created by marco on 30/06/14.
 */
public class StructureVisitor extends StructureBaseVisitor<StackVisitor> {
    public StructureVisitor() {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        StatementVisitor statementVisitor = new StatementVisitor();
        ElementVisitor elementVisitor = new ElementVisitor();

        statementVisitor.setExpressionVisitor(expressionVisitor);
        statementVisitor.setStructureVisitor(this);

        elementVisitor.setExpressionVisitor(expressionVisitor);
        elementVisitor.setStatementVisitor(statementVisitor);

        expressionVisitor.setStructureVisitor(this);

        setExpressionVisitor(expressionVisitor);
        setStatementVisitor(statementVisitor);
        setElementVisitor(elementVisitor);
    }

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
    public String visit(IClass structure) {
        pushStack(structure);
        getOutputWriter().append("class ").append(structure.getName()).append("(");
        if (structure.hasParents()) {
            for (IType type : structure.getParents()) {
                getOutputWriter().append(type.getName()).append(", ");
            }
        }
        if (structure.hasImplementations()) {
            for (IType type : structure.getImplementations()) {
                getOutputWriter().append(type.getName()).append(", ");
            }
        }
        getOutputWriter().append("):").newlineindented();
        for (IElement element : structure.getElements()) {
            getOutputWriter().append(element.visit(getElementVisitor()));
        }
        getOutputWriter().newlineunindented();
        popStack();
        return "";
    }

    @Override
    public String visit(IInterface structure) {
        getOutputWriter().append("class ").append(structure.getName()).append("(");
        if (structure.hasImplementations()) {
            for (IType type : structure.getImplementations()) {
                getOutputWriter().append(type.getName()).append(", ");
            }
        }
        getOutputWriter().append("):").newlineindented();
        for (IElement element : structure.getElements()) {
            getOutputWriter().append(element.visit(getElementVisitor()));
        }
        getOutputWriter().newlineunindented();
        return "";
    }

    @Override
    public String visit(IEnumeration structure) {
        getOutputWriter().append("class ").append(structure.getName()).append("(");
        if (structure.hasParents()) {
            for (IType type : structure.getParents()) {
                getOutputWriter().append(type.getName()).append(", ");
            }
        }
        if (structure.hasImplementations()) {
            for (IType type : structure.getImplementations()) {
                getOutputWriter().append(type.getName()).append(", ");
            }
        }
        getOutputWriter().append("):").newlineindented();
        if (structure.hasValues()) {
            for (IEnumField field : structure.getValues()) {
                getOutputWriter().append(field.visit(getElementVisitor()));
            }
        }
        if (structure.hasElements()) {
            for (IElement element : structure.getElements()) {
                getOutputWriter().append(element.visit(getElementVisitor()));
            }
        }
        getOutputWriter().newlineunindented();
        if (structure.hasValues()) {
            int enumerationValue = 1;
            for (IEnumField field : structure.getValues()) {
                getOutputWriter().append(structure.getName()).append(".").append(field.getName()).append(" = ");
                if (!field.hasArguments()) {
                    getOutputWriter().append(enumerationValue);
                } else {
                    getOutputWriter().append(structure.getName()).append("(");
                    for (IExpression e : field.getArguments()) {
                        getOutputWriter().append(e.visit(getExpressionVisitor())).append(", ");
                    }
                    getOutputWriter().append(")");
                }
                getOutputWriter().newline();
            }
        }
        return "";
    }
}
