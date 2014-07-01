package org.pinto.shinar.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by marco on 01/07/14.
 */
@Data
public class OutputString {
    @Setter(AccessLevel.PROTECTED)
    private StringBuilder builder;
    private Tabulator tabulator = new Tabulator();

    public OutputString(Tabulator tabulator, String... strings) {
        this(strings);
        this.tabulator = tabulator;
    }

    public OutputString(String... strings) {
        builder = new StringBuilder("");
        append(strings);
    }

    public OutputString(String string) {
        builder = new StringBuilder(string);
    }

    public OutputString() {
        builder = new StringBuilder();
    }

    public static String toString(String... values) {
        return new OutputString(values).toString();
    }

    public OutputString append(String string) {
        builder.append(string);
        return this;
    }

    public OutputString append(String... strings) {
        for (String string : strings)
            builder.append(string);
        return this;
    }

    public OutputString append(Object object) {
        builder.append(object.toString());
        return this;
    }

    public OutputString append(Object... objects) {
        for (Object object : objects)
            builder.append(object.toString());
        return this;
    }

    public OutputString newLine() {
        append("\n");
        return this;
    }

    public OutputString indent() {
        append(tabulator.indent());
        return this;
    }

    public OutputString unindent() {
        tabulator.unindent();
        append(tabulator.tabs());
        return this;
    }

    public OutputString appendTemplate(String template, String... strings) {
        builder.append(StringTemplate.of(template, strings));
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
