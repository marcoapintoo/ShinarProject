package org.shinar.neutral.representation.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.shinar.neutral.representation.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 22/06/14.
 */
@Data
public class ListVariableDeclaration implements Statement, Expression{
    @Setter(AccessLevel.PROTECTED) private List<VariableDeclaration> variables = new ArrayList<VariableDeclaration>();
}
