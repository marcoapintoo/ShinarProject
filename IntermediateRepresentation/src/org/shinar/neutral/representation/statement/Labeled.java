package org.shinar.neutral.representation.statement;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Labeled implements Statement {
    protected String label;
    protected CodeBlock block;
}
