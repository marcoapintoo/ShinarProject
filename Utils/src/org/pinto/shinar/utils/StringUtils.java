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
}
