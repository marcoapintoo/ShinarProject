package org.pinto.shinar.formatter.python;

import lombok.Data;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.pinto.shinar.language.core.expression.*;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.*;
import org.pinto.shinar.language.core.visitor.ExpressionBaseVisitor;

/**
 * Created by marco on 30/06/14.
 */
@Data
@ExtensionMethod({StringUtils.class, org.pinto.shinar.utils.StringUtils.class})
public class ExpressionVisitor extends ExpressionBaseVisitor {
    private IStatementVisitor<String> statementVisitor;
    private IStructureVisitor<String> structureVisitor;

    @Override
    public String visit(IArrayAccess expression) {
        return "@{array}[@{index}]".template(
                "array", expression.getArray().visit(this),
                "index", expression.getIndex().visit(this)
        );
    }

    @Override
    public String visit(IArray expression) {
        StringBuilder builder = "[".build();
        for (IExpression expressionItem : expression.getElements()) {
            builder.build(expressionItem.visit(this), ", ");
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
        StringBuilder builder = expression.getLeftOperand().visit(this).build();
        for (IExpression expressionItem : expression.getRightOperands()) {
            builder.build(expression.getOperator().toString(), " ", expressionItem.visit(this));
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
        StringBuilder builder = new StringBuilder();
        builder.append(expression.getExpression().visit(this));
        builder.append('.');
        builder.append(expression.getMethodName());
        builder.append('(');
        for (IExpression expressionItem : expression.getArguments()) {
            builder.append(expressionItem.visit(this));
            builder.append(", ");
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visit(IName expression) {
        String name = expression.getName();
        name = name.equals("self") ? "_self_" : name;
        StringBuilder builder = expression.getNamespace().visit(this).build(".", name);
        return builder.toString();
    }

    @Override
    public String visit(IParenthesized expression) {
        StringBuilder builder = "(".build(expression.getExpression().visit(this), ")");
        return builder.toString();
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
        return "super(self, @{basetype}).@{method_name}(".template(
                "base_type", expression.getContext().getCurrentType().visit(structureVisitor),
                "method_name", expression.getMethodName()
        );
    }

    @Override
    public String visit(IThis expression) {
        return "self";
    }

    @Override
    public String visit(IVariableDeclaration expression) {
        return super.visit(expression);
    }

    @Override
    public String visit(ITypeReference element) {
        return super.visit(element);
    }

    @Override
    public String visit(INamespace element) {
        return super.visit(element);
    }

    @Override
    public String visit(IGenericArgument element) {
        return super.visit(element);
    }

    @Override
    public String visit(IGenericParameter element) {
        return super.visit(element);
    }
}
