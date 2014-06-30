package org.pinto.shinar.language.core.structure;

/**
 * Created by marco on 29/06/14.
 */
public interface IField extends IElement {
    ITypeReference getType();

    IExpression getDefaultValue();
}
