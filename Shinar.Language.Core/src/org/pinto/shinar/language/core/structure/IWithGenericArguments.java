package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.structure.IGenericArgument;

/**
 * Created by marco on 29/06/14.
 */
public interface IWithGenericArguments {

    Iterable<IGenericArgument> getGenericArguments();

    boolean hasGenericArguments();
}
