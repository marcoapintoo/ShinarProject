package org.pinto.shinar.language.core.statement;

import org.pinto.shinar.language.core.structure.IExpression;

/**
 * Created by marco on 30/06/14.
 */
public interface IStatementVisitor<T> {
    T visit(IExpression statement);

    T visit(IAssert statement);

    T visit(IBlock statement);

    T visit(IBreak statement);

    T visit(IContinue statement);

    T visit(IDo statement);

    T visit(IEmpty statement);

    T visit(IForeach statement);

    T visit(IFor statement);

    T visit(IIf statement);

    T visit(ILabeled statement);

    T visit(IReturn statement);

    T visit(ISwitch statement);

    T visit(IThrow statement);

    T visit(ITry statement);

    T visit(ITypeDeclaration statement);

    T visit(IWhile statement);

    T visit(IWith statement);
}
