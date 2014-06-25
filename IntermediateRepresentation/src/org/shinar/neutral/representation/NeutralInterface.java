package org.shinar.neutral.representation;

import lombok.Data;

/**
 * Created by marco on 19/06/14.
 */
@Data
public class NeutralInterface extends NeutralCodeUnit {

    public static NeutralInterface of(NeutralClass base) {
        NeutralInterface result = new NeutralInterface();
        result.getFields().addAll(base.getFields());
        result.getMethods().addAll(base.getMethods());
        return result;
    }
}
