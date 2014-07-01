package org.pinto.shinar.language.core.visitor;

import lombok.Data;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.statement.*;
import org.pinto.shinar.language.core.structure.IExpression;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class StatementBaseVisitor<TStack extends IStackVisitorData> extends AbstractBaseVisitor<TStack> implements IStatementVisitor<String> {
    private IExpressionVisitor<String> expressionVisitor;

    @Override
    public String visit(IExpression statement) {
        return statement.visit(expressionVisitor);
    }

    @Override
    public String visit(IAssert statement) {
        return "";
    }

    @Override
    public String visit(IBlock statement) {
        return "";
    }

    @Override
    public String visit(IBreak statement) {
        return "";
    }

    @Override
    public String visit(IContinue statement) {
        return "";
    }

    @Override
    public String visit(IDo statement) {
        return "";
    }

    @Override
    public String visit(IEmpty statement) {
        return "";
    }

    @Override
    public String visit(IForeach statement) {
        return "";
    }

    @Override
    public String visit(IFor statement) {
        return "";
    }

    @Override
    public String visit(IIf statement) {
        return "";
    }

    @Override
    public String visit(ILabeled statement) {
        return "";
    }

    @Override
    public String visit(IReturn statement) {
        return "";
    }

    @Override
    public String visit(ISwitch statement) {
        return "";
    }

    @Override
    public String visit(IThrow statement) {
        return "";
    }

    @Override
    public String visit(ITryCatch statement) {
        return "";
    }

    @Override
    public String visit(ITry statement) {
        return "";
    }

    @Override
    public String visit(ITypeDeclaration statement) {
        return "";
    }

    @Override
    public String visit(IWhile statement) {
        return "";
    }

    @Override
    public String visit(IWith statement) {
        return "";
    }
}
