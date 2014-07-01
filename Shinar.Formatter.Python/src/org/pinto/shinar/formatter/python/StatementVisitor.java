package org.pinto.shinar.formatter.python;

import org.pinto.shinar.language.core.statement.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.visitor.StatementBaseVisitor;

/**
 * Created by marco on 30/06/14.
 */
public class StatementVisitor extends StatementBaseVisitor<StackVisitor> {
    @Override
    public String visit(IExpression statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IAssert statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IBlock statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IBreak statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IContinue statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IDo statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IEmpty statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IForeach statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IFor statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IIf statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(ILabeled statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IReturn statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(ISwitch statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IThrow statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(ITryCatch statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(ITry statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(ITypeDeclaration statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IWhile statement) {
        return super.visit(statement);
    }

    @Override
    public String visit(IWith statement) {
        return super.visit(statement);
    }
}
