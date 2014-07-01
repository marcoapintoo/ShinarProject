package org.pinto.shinar.formatter.python;

import lombok.Data;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.pinto.shinar.language.core.expression.*;
import org.pinto.shinar.language.core.structure.*;
import org.pinto.shinar.language.core.visitor.ExpressionBaseVisitor;
import org.pinto.shinar.utils.OutputString;

/**
 * Created by marco on 30/06/14.
 */
@Data
@ExtensionMethod({StringUtils.class, org.pinto.shinar.utils.StringUtils.class})
public class ExpressionVisitor extends ExpressionBaseVisitor<StackVisitor> {
    protected IStructureVisitor<String> structureVisitor;
    @Override
    public String visit(IArrayAccess expression) {
        return "@{array}[@{index}]".template(
                "array", expression.getArray().visit(this),
                "index", expression.getIndex().visit(this)
        );
    }

    @Override
    public String visit(IArray expression) {
        OutputString builder = new OutputString("[");
        for (IExpression expressionItem : expression.getElements()) {
            builder.append(expressionItem.visit(this), ", ");
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String visit(IAssignment expression) {
        return "@{leftExpression} @{operator} @{rightExpression}".template(
                "leftExpression", expression.getLeftExpression().visit(this),
                "operator", expression.getOperator().toString(),
                "rightExpression", expression.getRightExpression().visit(this)
        );
    }

    @Override
    public String visit(ICast expression) {
        return expression.getExpression().visit(this);
    }

    @Override
    public String visit(IConditional expression) {
        //TODO: Verify this
        return "(@{trueAction} if @{condition} else @{falseAction})".template(
                "condition", expression.getCondition().visit(this),
                "trueAction", expression.getTrueAction().visit(this),
                "falseAction", expression.getFalseAction().visit(this)
        );
    }

    @Override
    public String visit(IFieldAccess expression) {
        return "@{expression}.@{field}".template(
                "expression", expression.getExpression().visit(this),
                "field", expression.getField()
        );
    }

    @Override
    public String visit(IInfixOperation expression) {
        OutputString builder = new OutputString(expression.getLeftOperand().visit(this));
        for (IExpression expressionItem : expression.getRightOperands()) {
            builder.append(expression.getOperator().toString(), " ", expressionItem.visit(this));
        }
        return builder.toString();
    }

    @Override
    public String visit(IInstanceof expression) {
        return "@{expression} is @{type}".template(
                "expression", expression.getExpression().visit(this),
                "type", expression.getType().visit(this)
        );
    }

    @Override
    public String visit(ILiteral expression) {
        return expression.getValue().toString();
    }

    @Override
    public String visit(IMethodCall expression) {
        OutputString builder = new OutputString(expression.getExpression().visit(this),
                ".", expression.getMethodName(), "(");
        for (IExpression expressionItem : expression.getArguments()) {
            builder.append(expressionItem.visit(this), ", ");
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visit(IName expression) {
        String name = expression.getName();
        name = name.equals("self") ? "_self_" : name;
        return OutputString.toString(expression.getNamespace().visit(this), ".", name);
    }

    @Override
    public String visit(IParenthesized expression) {
        return OutputString.toString("(", expression.getExpression().visit(this), ")");
    }

    @Override
    public String visit(IPostfixOperation expression) {
        throw new RuntimeException("IPostfixOperation is not supported!");
    }

    @Override
    public String visit(IPrefixOperation expression) {
        throw new RuntimeException("IPrefixOperation is not supported!");
    }

    @Override
    public String visit(ISuperFieldAccess expression) {
        return super.visit(expression);
    }

    @Override
    public String visit(ISuperMethodCall expression) {
        OutputString builder = new OutputString("super(self, @{basetype}).@{method_name}(".template(
                "base_type", expression.getContext().getCurrentType().visit(getStructureVisitor()),
                "method_name", expression.getMethodName()
        ));
        for (IExpression e : expression.getArguments()) {
            builder.append(e.visit(this), ", ");
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visit(IThis expression) {
        return "self";
    }

    @Override
    public String visit(IVariableDeclaration expression) {
        return "@{name} = @{defaultvalue}".template(
                "name", expression.getName(),
                "defaultvalue", expression.getDefaultValue().visit(this)
        );
    }

    @Override
    public String visit(ITypeReference element) {
        INamespace namespace = element.getType().getContext().getCurrentNamespace();
        return "@{namespace}@{typename}".template(
                "namespace", namespace == null ? "" : (namespace.getFullName() + "."),
                "typename", element.getType().getName()
        );
    }

    @Override
    public String visit(INamespace element) {
        if (element == null) return "";
        if (element.getRoot() == null) return element.getName();
        return OutputString.toString(element.getRoot().visit(this), ".", element.getName());
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
