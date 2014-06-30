package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Continue implements IContinue{
    private String label;
    private Context context;

    @Override
    public boolean hasLabel() {
        return label != null && !label.equals("");
    }

}
