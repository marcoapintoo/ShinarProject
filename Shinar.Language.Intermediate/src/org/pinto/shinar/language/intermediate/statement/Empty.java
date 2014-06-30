package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.intermediate.structure.Context;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Empty implements IEmpty{
    private Context context;
}
