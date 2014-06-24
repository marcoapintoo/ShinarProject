package org.shinar.neutral.representation;

import lombok.Data;
import org.shinar.neutral.representation.statement.Statement;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class NeutralTypeDeclaration extends NeutralCodeUnit implements Statement {
    /**
     * If this sentence is a type definition it is true like "class A<T extends Default&Serializable>"
     * Otherwise, if sentence is a type call it is false like "List<String>"
     */
    protected boolean definition = false;
}
