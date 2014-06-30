package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.structure.IGenericParameter;

/**
 * Created by marco on 29/06/14.
 */
public interface IWithGenerics {
    Iterable<IGenericParameter> getGenerics();

    boolean hasGenerics();
}
