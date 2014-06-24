package org.shinar.neutral.representation.statement;

import lombok.Data;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Continue implements Statement {
    protected String label;
}
