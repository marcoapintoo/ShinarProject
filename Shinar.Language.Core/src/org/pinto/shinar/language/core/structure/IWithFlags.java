package org.pinto.shinar.language.core.structure;

import org.pinto.shinar.language.core.structure.IFlag;

/**
 * Created by marco on 29/06/14.
 */
public interface IWithFlags {
    Iterable<IFlag> getFlags();

    boolean containsFlag(IFlag flag);
}
