package org.pinto.shinar.language.intermediate.expression;
import org.pinto.shinar.language.core.expression.*;
import lombok.*;
import org.pinto.shinar.language.intermediate.structure.Namespace;

/**
 * Created by marco on 29/06/14.
 */
@Data
public class SuperFieldAccess extends FieldAccess implements ISuperFieldAccess{
    private Namespace namespace;
}
