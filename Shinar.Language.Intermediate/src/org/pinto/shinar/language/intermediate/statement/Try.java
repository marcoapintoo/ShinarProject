package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Try implements ITry{
    private IStatement verifiedAction;
    private IStatement finallyAction;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<ITryCatch> catchErrors = new ArrayList<ITryCatch>();
    private Context context;
}
