package org.pinto.shinar.utils;

/**
 * Created by marco on 30/06/14.
 */
public class StringUtils {
    public static String template(String template, String... values) {
        return StringTemplate.of(template, values);
    }

    public static StringBuilder build(StringBuilder builder, String... values) {
        for (String s : values) {
            builder.append(s);
        }
        return builder;
    }

    public static StringBuilder build(String string, String... values) {
        StringBuilder builder = new StringBuilder(string);
        for (String s : values) {
            builder.append(s);
        }
        return builder;
    }

    public static StringBuilder build(String string) {
        StringBuilder builder = new StringBuilder(string);
        return builder;
    }
/*
    public static String template(String template) {
        return StringTemplate.of(template, new String[0]);
    }
    public static String template(String template, String k0, String v0) {
        return StringTemplate.of(template, k0, v0);
    }
    public static String template(String template, String k0, String v0, String k1, String v1) {
        return StringTemplate.of(template, k0, v0, k1, v1);
    }
    public static String template(String template, String k0, String v0, String k1, String v1, String k2, String v2) {
        return StringTemplate.of(template, k0, v0, k1, v1, k2, v2);
    }
    public static String template(String template, String k0, String v0, String k1, String v1, String k2, String v2, String k3, String v3) {
        return StringTemplate.of(template, k0, v0, k1, v1, k2, v2, k3, v3);
    }

    public static StringBuilder build(StringBuilder builder){
        return builder;
    }
    public static StringBuilder build(StringBuilder builder, String v0){
        builder.append(v0);
        return builder;
    }
    public static StringBuilder build(StringBuilder builder, String v0, String v1){
        builder.append(v0);
        builder.append(v1);
        return builder;
    }
    public static StringBuilder build(StringBuilder builder, String v0, String v1, String v2){
        builder.append(v0);
        builder.append(v1);
        builder.append(v2);
        return builder;
    }

    public static StringBuilder build(String string, String v0){
        return build(new StringBuilder(), v0);
    }
    public static StringBuilder build(String string, String v0, String v1){
        return build(new StringBuilder(), v0, v1);
    }
    public static StringBuilder build(String string, String v0, String v1, String v2){
        return build(new StringBuilder(), v0, v1, v2);
    }
*/
}
