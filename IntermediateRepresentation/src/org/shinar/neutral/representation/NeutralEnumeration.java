package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 19/06/14.
 */
@Data
public class NeutralEnumeration extends NeutralCodeUnit {
    @Setter(AccessLevel.PRIVATE)
    private List<Field> fields = new ArrayList<Field>();
}
