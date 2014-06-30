package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.expression.IVariableDeclaration;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class TryCatch implements ITryCatch{
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IVariableDeclaration> errors = new ArrayList<IVariableDeclaration>();
    private IStatement action;
}
