package org.pinto.shinar.language.intermediate.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.pinto.shinar.language.core.statement.IStatementVisitor;
import org.pinto.shinar.language.core.statement.ITry;
import org.pinto.shinar.language.core.statement.ITryCatch;
import org.pinto.shinar.language.core.structure.IStatement;
import org.pinto.shinar.language.intermediate.structure.Context;

import java.util.ArrayList;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class Try implements ITry {
    private IStatement verifiedAction;
    private IStatement finallyAction;
    @Setter(AccessLevel.PROTECTED)
    private ArrayList<ITryCatch> catchErrors = new ArrayList<ITryCatch>();
    private Context context;

    @Override
    public <T> T visit(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
