package org.pinto.shinar.language.intermediate.statement;
import org.pinto.shinar.language.core.statement.*;
import lombok.*;
import org.pinto.shinar.language.core.structure.IStatement;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Block implements IBlock{
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<IStatement> statements = new ArrayList<IStatement>();
    @Override
    public boolean hasContent() {
        return statements.size()>0;
    }
}
