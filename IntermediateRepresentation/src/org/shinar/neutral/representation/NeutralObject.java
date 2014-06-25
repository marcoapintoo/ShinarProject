package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class NeutralObject {
    private ObjectVisibility visibility = ObjectVisibility.Package;
    @Setter(AccessLevel.PROTECTED)
    private Set<ObjectAccess> access = EnumSet.of(ObjectAccess.Default);
    private ObjectInstantiation instantiation = ObjectInstantiation.Instance;

    private String name;

    /*
    public String getCode(SimpleFormatter formatter) {
        //try {
            //MultiMethod.redispatch(this, formatter);
            return formatter.format(this);
        //}
    }*/
}
