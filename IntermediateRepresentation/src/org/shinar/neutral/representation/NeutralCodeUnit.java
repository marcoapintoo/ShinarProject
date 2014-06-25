package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class NeutralCodeUnit extends NeutralObject {
    private boolean primitive = true;
    private Directory directory;
    @Setter(AccessLevel.PROTECTED)
    private List<NeutralCodeUnit> parents = new ArrayList<NeutralCodeUnit>();
    @Setter(AccessLevel.PROTECTED)
    private List<NeutralCodeUnit> implementations = new ArrayList<NeutralCodeUnit>();
    @Setter(AccessLevel.PROTECTED)
    private List<NeutralCodeUnit> typeParameters = new ArrayList<NeutralCodeUnit>();
    @Setter(AccessLevel.PRIVATE)
    private List<Field> fields = new ArrayList<Field>();
    @Setter(AccessLevel.PRIVATE)
    private List<Method> methods = new ArrayList<Method>();

    public String getQualifiedName() {
        return directory.getFullName() + "." + getName();
    }
}
