package org.shinar.neutral.representation.expression;

import lombok.Data;
import org.shinar.neutral.representation.Directory;

/**
 * Created by marco on 23/06/14.
 */
@Data
public class Name implements Expression {
    protected String name = "";
    protected Directory namespace = null;

    public static Name of(String fullName) {
        String name = fullName;
        Name importDeclaration = new Name();
        if (name.contains(".")) {
            int position = name.lastIndexOf('.');
            importDeclaration.setNamespace(Directory.of(name.substring(0, position).toString()));
            name = name.substring(position + 1);
        }
        importDeclaration.setName(name);
        return importDeclaration;
    }
}
