package org.pinto.shinar.language.intermediate.structure;

import lombok.Data;
import org.pinto.shinar.language.core.structure.IContext;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Context implements IContext {
    private Namespace currentNamespace;
    private Type currentType;
}
