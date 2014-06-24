package org.shinar.neutral.representation;

import lombok.Value;

/**
 * Created by marco on 18/06/14.
 */
public enum ObjectAccess {
    Default,
    Native,
    Final
}
/*
@Value
public class ObjectAccess {
    String methodName;
    public final static ObjectAccess Default = new ObjectAccess("object");
    public final static ObjectAccess Static = new ObjectAccess("static");
}
*/
