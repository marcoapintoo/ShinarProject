package org.shinar.neutral.representation;

/**
 * Created by marco on 18/06/14.
 */
public enum ObjectVisibility {
    Protected,
    Private,
    Public,
    Package
}
/*
@Value
public class ObjectVisibility {
    String methodName;

    @Embed public final static ObjectVisibility Protected = new ObjectVisibility("protected");
    public final static ObjectVisibility Private = new ObjectVisibility("private");
    public final static ObjectVisibility Public = new ObjectVisibility("public");
    public final static ObjectVisibility Package = new ObjectVisibility("package");
}
*/

