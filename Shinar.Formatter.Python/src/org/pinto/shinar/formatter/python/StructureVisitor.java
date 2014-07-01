package org.pinto.shinar.formatter.python;

import org.pinto.shinar.language.core.visitor.StructureBaseVisitor;

/**
 * Created by marco on 30/06/14.
 */
public class StructureVisitor extends StructureBaseVisitor {
    public StructureVisitor() {
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        StatementVisitor statementVisitor = new StatementVisitor();
        ElementVisitor elementVisitor = new ElementVisitor();
        statementVisitor.setExpressionVisitor(expressionVisitor);
        elementVisitor.setExpressionVisitor(expressionVisitor);
        elementVisitor.setStatementVisitor(statementVisitor);
        setExpressionVisitor(expressionVisitor);
        setStatementVisitor(statementVisitor);
        setElementVisitor(elementVisitor);
    }

}
