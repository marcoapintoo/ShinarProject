package org.pinto.shinar.language.core.visitor;

import lombok.Data;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.*;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class StructureBaseVisitor<TStack extends IStackVisitorData> extends AbstractBaseVisitor<TStack> implements IStructureVisitor<String> {
    private IExpressionVisitor<String> expressionVisitor;
    private IStatementVisitor<String> statementVisitor;
    private IElementVisitor<String> elementVisitor;

    @Override
    public String visit(IClass structure) {
        return "";
    }

    @Override
    public String visit(IInterface structure) {
        return "";
    }

    @Override
    public String visit(IEnumeration structure) {
        return "";
    }
}
