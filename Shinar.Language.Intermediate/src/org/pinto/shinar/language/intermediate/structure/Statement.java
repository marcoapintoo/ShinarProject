package org.pinto.shinar.language.intermediate.structure;
import org.pinto.shinar.language.core.structure.*;
import lombok.*;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Statement implements IStatement{
    @Override
    public IContext getContext() {
        return null;
    }
}
