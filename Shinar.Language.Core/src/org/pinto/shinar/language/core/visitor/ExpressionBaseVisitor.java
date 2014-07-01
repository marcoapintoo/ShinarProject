package org.pinto.shinar.language.core.visitor;

import org.pinto.shinar.language.core.expression.*;
import org.pinto.shinar.language.core.structure.*;

/**
 * Created by marco on 30/06/14.
 */
public class ExpressionBaseVisitor extends AbstractBaseVisitor implements IExpressionVisitor<String>, IStructureFragmentVisitor<String> {
    @Override
    public String visit(IArrayAccess expression) {
        return "";
    }

    @Override
    public String visit(IArray expression) {
        return "";
    }

    @Override
    public String visit(IAssignment expression) {
        return "";
    }

    @Override
    public String visit(ICast expression) {
        return "";
    }

    @Override
    public String visit(IConditional expression) {
        return "";
    }

    @Override
    public String visit(IFieldAccess expression) {
        return "";
    }

    @Override
    public String visit(IInfixOperation expression) {
        return "";
    }

    @Override
    public String visit(IInstanceof expression) {
        return "";
    }

    @Override
    public String visit(ILiteral expression) {
        return "";
    }

    @Override
    public String visit(IMethodCall expression) {
        return "";
    }

    @Override
    public String visit(IName expression) {
        return "";
    }

    @Override
    public String visit(IParenthesized expression) {
        return "";
    }

    @Override
    public String visit(IPostfixOperation expression) {
        return "";
    }

    @Override
    public String visit(IPrefixOperation expression) {
        return "";
    }

    @Override
    public String visit(ISuperFieldAccess expression) {
        return "";
    }

    @Override
    public String visit(ISuperMethodCall expression) {
        return "";
    }

    @Override
    public String visit(IThis expression) {
        return "";
    }

    @Override
    public String visit(IVariableDeclaration expression) {
        return "";
    }

    @Override
    public String visit(ITypeReference element) {
        return "";
    }

    @Override
    public String visit(INamespace element) {
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
