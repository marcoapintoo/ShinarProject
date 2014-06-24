package org.shinar.neutral.representation.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Try implements Statement {
    protected CodeBlock tryBlock;
    protected CodeBlock finallyBlock;
    @Setter(AccessLevel.PROTECTED) protected List<TryCatch> catches = new ArrayList<TryCatch>();
}
