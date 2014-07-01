package org.pinto.shinar.formatter.python;

import lombok.Data;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.pinto.shinar.language.core.expression.*;
import org.pinto.shinar.language.core.structure.*;
import org.pinto.shinar.language.core.visitor.ExpressionBaseVisitor;
import org.pinto.shinar.utils.IOutputWriter;

/**
 * Created by marco on 30/06/14.
 */
@Data
@ExtensionMethod({StringUtils.class, org.pinto.shinar.utils.StringUtils.class})
public class ExpressionVisitor extends ExpressionBaseVisitor<StackVisitor> {
    protected IStructureVisitor<String> structureVisitor;

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
    public String visit(IArrayAccess expression) {
        pushStack(expression);
        getOutputWriter().append("@{array}[@{index}]".template(
                "array", expression.getArray().visit(this),
                "index", expression.getIndex().visit(this)
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(IArray expression) {
        pushStack(expression);
        getOutputWriter().append("[");
        for (IExpression expressionItem : expression.getElements()) {
            getOutputWriter().append(expressionItem.visit(this)).append(", ");
        }
        getOutputWriter().append("]");
        popStack();
        return "";
    }

    @Override
    public String visit(IAssignment expression) {
        pushStack(expression);
        getOutputWriter().append("@{leftExpression} @{operator} @{rightExpression}".template(
                "leftExpression", expression.getLeftExpression().visit(this),
                "operator", expression.getOperator().toString(),
                "rightExpression", expression.getRightExpression().visit(this)
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(ICast expression) {
        pushStack(expression);
        getOutputWriter().append(expression.getExpression().visit(this));
        popStack();
        return "";
    }

    @Override
    public String visit(IConditional expression) {
        pushStack(expression);
        //TODO: Verify this
        getOutputWriter().append("(@{trueAction} if @{condition} else @{falseAction})".template(
                "condition", expression.getCondition().visit(this),
                "trueAction", expression.getTrueAction().visit(this),
                "falseAction", expression.getFalseAction().visit(this)
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(IFieldAccess expression) {
        pushStack(expression);
        getOutputWriter().append("@{expression}.@{field}".template(
                "expression", expression.getExpression().visit(this),
                "field", expression.getField()
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(IInfixOperation expression) {
        pushStack(expression);
        getOutputWriter().append(expression.getLeftOperand().visit(this));
        for (IExpression expressionItem : expression.getRightOperands()) {
            getOutputWriter().append(expression.getOperator().toString()).append(" ").append(expressionItem.visit(this));
        }
        popStack();
        return "";
    }

    @Override
    public String visit(IInstanceof expression) {
        pushStack(expression);
        getOutputWriter().append("@{expression} is @{type}".template(
                "expression", expression.getExpression().visit(this),
                "type", expression.getType().visit(this)
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(ILiteral expression) {
        pushStack(expression);
        getOutputWriter().append(expression.getValue().toString());
        popStack();
        return "";
    }

    @Override
    public String visit(IMethodCall expression) {
        pushStack(expression);
        getOutputWriter().append(expression.getExpression().visit(this))
                .append(".").append(expression.getMethodName()).append("(");
        for (IExpression expressionItem : expression.getArguments()) {
            getOutputWriter().append(expressionItem.visit(this)).append(", ");
        }
        getOutputWriter().append(")");
        popStack();
        return "";
    }

    @Override
    public String visit(IName expression) {
        pushStack(expression);
        String name = expression.getName();
        name = name.equals("self") ? "_self_" : name;
        getOutputWriter().append(expression.getNamespace().visit(this)).append(".").append(name);
        popStack();
        return "";
    }

    @Override
    public String visit(IParenthesized expression) {
        pushStack(expression);
        getOutputWriter().append("(").append(expression.getExpression().visit(this)).append(")");
        popStack();
        return "";
    }

    @Override
    public String visit(IPostfixOperation expression) {
        pushStack(expression);
        throw new RuntimeException("IPostfixOperation is not supported!");
    }

    @Override
    public String visit(IPrefixOperation expression) {
        pushStack(expression);
        throw new RuntimeException("IPrefixOperation is not supported!");
    }

    @Override
    public String visit(ISuperFieldAccess expression) {
        pushStack(expression);
        getOutputWriter().append("super(self, @{basetype}).@{field_name}(".template(
                "base_type", expression.getContext().getCurrentType().visit(getStructureVisitor()),
                "field_name", expression.getField()
        ));

        popStack();
        return "";
    }

    @Override
    public String visit(ISuperMethodCall expression) {
        pushStack(expression);
        getOutputWriter().append("super(self, @{basetype}).@{method_name}(".template(
                "base_type", expression.getContext().getCurrentType().visit(getStructureVisitor()),
                "method_name", expression.getMethodName()
        ));
        for (IExpression e : expression.getArguments()) {
            getOutputWriter().append(e.visit(this)).append(", ");
        }
        getOutputWriter().append(")");
        popStack();
        return "";
    }

    @Override
    public String visit(IThis expression) {
        pushStack(expression);
        getOutputWriter().append("self");
        popStack();
        return "";
    }

    @Override
    public String visit(IVariableDeclaration expression) {
        pushStack(expression);
        getOutputWriter().append("@{name} = @{defaultvalue}".template(
                "name", expression.getName(),
                "defaultvalue", expression.getDefaultValue().visit(this)
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(ITypeReference element) {
        pushStack(element);
        INamespace namespace = element.getType().getContext().getCurrentNamespace();
        getOutputWriter().append("@{namespace}@{typename}".template(
                "namespace", namespace == null ? "" : (namespace.getFullName() + "."),
                "typename", element.getType().getName()
        ));
        popStack();
        return "";
    }

    @Override
    public String visit(INamespace element) {
        pushStack(element);
        if (element != null) {
            if (element.getRoot() != null) {
                getOutputWriter().append(element.getRoot().visit(this)).append(".");
            }
            getOutputWriter().append(element.getName());
        }
        popStack();
        return "";
    }

    @Override
    public String visit(IGenericArgument element) {
        return "";
    }

    @Override
    public String visit(IGenericParameter element) {
        return "";
    }
}
