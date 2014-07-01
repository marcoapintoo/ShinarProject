package org.pinto.shinar.language.core.visitor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.expression.IExpressionVisitor;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.structure.IElementVisitor;
import org.pinto.shinar.language.core.structure.IStructureVisitor;

import java.util.Stack;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class AbstractBaseVisitor<TStack extends IStackVisitorData> {
    @Setter(AccessLevel.NONE)
    private Stack<TStack> stack = new Stack<TStack>();

    protected <T> IExpressionVisitor<T> getLastExpressionVisitor() {
        return getLastElementType(IExpressionVisitor.class);
    }

    protected <T> IStatementVisitor<T> getLastStatementVisitor() {
        return getLastElementType(IStatementVisitor.class);
    }

    protected <T> IStructureVisitor<T> getLastStructureVisitor() {
        return getLastElementType(IExpressionVisitor.class);
    }

    protected <T> IElementVisitor<T> getLastElementVisitor() {
        return getLastElementType(IElementVisitor.class);
    }

    protected <T> T getLastElementType(Class<?> klazz) {
        for (TStack data : stack) {
            if (data.getData() == null) continue;
            if (klazz.isAssignableFrom(data.getData().getClass())) {
                return (T) data.getData();
            }
        }
        return null;
    }
}
