package org.shinar.neutral.representation.statement;

import lombok.Data;
import org.shinar.neutral.representation.expression.Expression;

/**
 * Created by marco on 22/06/14.
 */
@Data
public class TryCatch {
    protected ListVariableDeclaration exceptions;
    protected CodeBlock block;
}
