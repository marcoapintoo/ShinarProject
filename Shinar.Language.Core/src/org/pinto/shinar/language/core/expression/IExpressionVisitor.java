package org.pinto.shinar.language.core.expression;

/**
 * Created by marco on 30/06/14.
 */
public interface IExpressionVisitor<T> {
    T visit(IArrayAccess expression);

    T visit(IArray expression);

    T visit(IAssignment expression);

    T visit(ICast expression);

    T visit(IConditional expression);

    T visit(IFieldAccess expression);

    T visit(IInfixOperation expression);

    T visit(IInstanceof expression);

    T visit(ILiteral expression);

    T visit(IMethodCall expression);

    T visit(IName expression);

    T visit(IParenthesized expression);

    T visit(IPostfixOperation expression);

    T visit(IPrefixOperation expression);

    T visit(ISuperFieldAccess expression);

    T visit(ISuperMethodCall expression);

    T visit(IThis expression);

    T visit(IVariableDeclaration expression);
}
