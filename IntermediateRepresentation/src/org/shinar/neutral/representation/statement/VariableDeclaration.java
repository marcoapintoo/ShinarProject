package org.shinar.neutral.representation.statement;

import lombok.Data;
import org.shinar.neutral.representation.NeutralCodeUnit;
import org.shinar.neutral.representation.NeutralTypeDeclaration;
import org.shinar.neutral.representation.expression.Expression;

import java.util.EnumSet;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class VariableDeclaration implements Statement, Expression{
    protected EnumSet<VariableModifier> modifiers = EnumSet.of(VariableModifier.Default);
    protected String name;
    protected Expression defaultExpression = null;
    private NeutralCodeUnit type;
    private boolean unknownLength = false;
}
