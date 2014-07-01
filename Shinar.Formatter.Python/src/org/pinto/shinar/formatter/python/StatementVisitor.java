package org.pinto.shinar.formatter.python;

import lombok.Data;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.pinto.shinar.language.core.expression.IVariableDeclaration;
import org.pinto.shinar.language.core.statement.*;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.core.structure.IStructureVisitor;
import org.pinto.shinar.language.core.visitor.StatementBaseVisitor;
import org.pinto.shinar.utils.IOutputWriter;

/**
 * Created by marco on 30/06/14.
 */
@Data
@ExtensionMethod({StringUtils.class, org.pinto.shinar.utils.StringUtils.class})
public class StatementVisitor extends StatementBaseVisitor<StackVisitor> {
    private IStructureVisitor<String> structureVisitor;
    private IOutputWriter outputWriter;

    private void popStack() {
        getStack().pop();
    }

    private void pushStack(Object expression) {
        getStack().push(new StackVisitor(this, expression, getOutputWriter()));
    }

    private IOutputWriter getOutputWriter() {
        if (getStack().empty()) {
            return outputWriter;
        }
        return getStack().peek().getOutputWriter();
    }

    @Override
    public String visit(IAssert statement) {
        pushStack(statement);
        getOutputWriter().append("if ").append(statement.getExpression().visit(this)).append(": ").newlineindented();
        getOutputWriter().append("print ").append(statement.getMessage().visit(this)).newlineunindented();
        getOutputWriter().append("exit(-1)").newlineunindented();
        popStack();
        return "";
    }

    @Override
    public String visit(IBlock statement) {
        pushStack(statement);
        if (!statement.hasContent()) {
            getOutputWriter().append("pass");
        }
        for (IStatement s : statement.getStatements()) {
            getOutputWriter().append(s.visit(this));
        }
        popStack();
        return "";
    }

    @Override
    public String visit(IBreak statement) {
        pushStack(statement);
        getOutputWriter().append("break");
        popStack();
        return "";
    }

    @Override
    public String visit(IContinue statement) {
        pushStack(statement);
        getOutputWriter().append("continue");
        popStack();
        return "";
    }

    @Override
    public String visit(IDo statement) {
        pushStack(statement);
        statement.getAction().visit(this);
        getOutputWriter().append("while ").append(statement.getCondition().visit(this)).append(":");
        getOutputWriter().newlineindented().append(statement.getAction().visit(this));
        getOutputWriter().newlineunindented();
        popStack();
        return "";
    }

    @Override
    public String visit(IEmpty statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(IForeach statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(IFor statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(IIf statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(ILabeled statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(IReturn statement) {
        pushStack(statement);

        popStack();
        return "";
    }

    @Override
    public String visit(ISwitch statement) {
        pushStack(statement);
        throw new RuntimeException("Switch not supported");
        //popStack();
        //return "";
    }

    @Override
    public String visit(IThrow statement) {
        pushStack(statement);
        getOutputWriter().append("raise ").append(statement.getExpression().visit(this));
        popStack();
        return "";
    }

    @Override
    public String visit(ITry statement) {
        pushStack(statement);
        getOutputWriter().append("try:").newlineindented().append(statement.getVerifiedAction().visit(this));
        for (ITryCatch tryCatch : statement.getCatchErrors()) {
            getOutputWriter().append("except (");
            String name = "";
            for (IVariableDeclaration declaration : tryCatch.getErrors()) {
                getOutputWriter().append(declaration.getType().getType().getName()).append(", ");
                name = declaration.getName();
            }
            getOutputWriter().append(") as ").append(name).append(":").newlineindented().append(tryCatch.getAction().visit(this)).newlineunindented();
        }
        IStatement finallyStatement = statement.getFinallyAction();
        if (finallyStatement != null) {
            getOutputWriter().append("finally:").newlineindented().append(statement.getFinallyAction().visit(this)).newlineunindented();
        }
        popStack();
        return "";
    }

    @Override
    public String visit(ITypeDeclaration statement) {
        pushStack(statement);
        statement.getDeclaredType().visit(getStructureVisitor());
        popStack();
        return "";
    }

    @Override
    public String visit(IWhile statement) {
        pushStack(statement);
        getOutputWriter().append("while ").append(statement.getCondition().visit(this)).append(":");
        getOutputWriter().newlineindented().append(statement.getAction().visit(this));
        getOutputWriter().newlineunindented();
        popStack();
        return "";
    }

    @Override
    public String visit(IWith statement) {
        pushStack(statement);
        getOutputWriter().append("with ");
        for (IExpression expression : statement.getResources()) {
            getOutputWriter().append(expression.visit(this)).append(", ");
        }
        getOutputWriter().append(":").newlineindented().append(statement.visit(this)).newlineunindented();
        popStack();
        return "";
    }
}
