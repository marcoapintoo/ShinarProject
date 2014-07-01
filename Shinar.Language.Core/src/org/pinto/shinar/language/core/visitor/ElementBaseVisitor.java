package org.pinto.shinar.language.core.visitor;

import lombok.Data;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IElementVisitor;
import org.pinto.shinar.language.core.structure.IEnumField;
import org.pinto.shinar.language.core.structure.IField;
import org.pinto.shinar.language.core.structure.IMethod;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class ElementBaseVisitor extends AbstractBaseVisitor implements IElementVisitor<String> {
    private IExpressionVisitor<String> expressionVisitor;
    private IStatementVisitor<String> statementVisitor;

    @Override
    public String visit(IField element) {
        return "";
    }

    @Override
    public String visit(IMethod element) {
        return "";
    }

    @Override
    public String visit(IEnumField element) {
        return "";
    }
}

