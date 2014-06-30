package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IWithFlags;
import org.pinto.shinar.language.core.structure.IWithName;
import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.core.structure.ITypeReference;

/**
 * Created by marco on 29/06/14.
 */
public interface IVariableDeclaration extends IStatement, IExpression, IWithName, IWithFlags {
    ITypeReference getType();

    IExpression getDefaultValue();
}
