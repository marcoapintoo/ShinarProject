package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.expression.IMethodParameterDeclaration;
import org.pinto.shinar.language.core.statement.IBlock;

/**
 * Created by marco on 29/06/14.
 */
public interface IMethod extends IElement, IWithGenerics {
    ITypeReference getReturnType();

    Iterable<IMethodParameterDeclaration> getParameters();

    boolean hasParameters();


    IBlock getBlock();
}
