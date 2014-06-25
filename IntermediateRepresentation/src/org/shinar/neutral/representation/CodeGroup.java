package org.shinar.neutral.representation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 24/06/14.
 */
@Data
public class CodeGroup {
    @Setter(AccessLevel.PROTECTED)
    List<NeutralCodeUnit> units = new ArrayList<NeutralCodeUnit>();
}
