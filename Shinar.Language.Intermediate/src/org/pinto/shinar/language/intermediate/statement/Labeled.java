package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IContext;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;
import org.pinto.shinar.language.intermediate.structure.Expression;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Labeled implements ILabeled{
    private String label;
    private Block block;
    private Context context;
}
