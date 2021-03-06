package org.shinar.neutral.representation.expression;

import lombok.Data;
import org.shinar.neutral.representation.NeutralTypeDeclaration;

/**
 * Created by marco on 21/06/14.
 */
@Data
public class Instanceof implements Expression {
    protected Expression expression;
    protected NeutralTypeDeclaration type;
}
