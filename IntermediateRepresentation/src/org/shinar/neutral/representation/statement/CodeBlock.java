package org.shinar.neutral.representation.statement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 22/06/14.
 */
@Data
public class CodeBlock implements Statement {
    @Setter(AccessLevel.PROTECTED)
    List<Statement> statements = new ArrayList<Statement>();
}
