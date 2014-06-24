package org.shinar.neutral.representation;

import lombok.Data;
import org.shinar.neutral.representation.expression.Name;

/**
 * Created by marco on 20/06/14.
 */
@Data
public class Import extends Name {
    public String getFullName(){
        return namespace!=null?namespace.getFullName() + "." + name: name;
    }
    public boolean isOnDemand(){
        return name == "*";
    }

    public static Import of(String fullName, boolean onDemand){
        if(onDemand){
            fullName += ".*";
        }
        Name name = Name.of(fullName);
        Import importDeclaration = new Import();
        importDeclaration.setName(name.getName());
        importDeclaration.setNamespace(name.getNamespace());
        return importDeclaration;
    }
}
