package org.pinto.shinar.language.core.expression;

import org.pinto.shinar.language.core.structure.IExpression;
import org.pinto.shinar.language.core.structure.IWithContext;
import org.pinto.shinar.language.core.structure.IWithGenericArguments;

/**
 * Created by marco on 29/06/14.
 */
public interface IMethodCall extends IExpression, IWithContext, IWithGenericArguments {
    IExpression getExpression();

    String getMethodName();

    Iterable<IExpression> getArguments();
}
