package org.pinto.shinar.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by marco on 25/06/14.
 */
@Data
public class Tabulator {
    protected String baseTabulator = "  ";
    @Setter(AccessLevel.PROTECTED)
    private int tabular = 0;

    public Tabulator() {
    }

    public Tabulator(final String tabular) {
        baseTabulator = tabular;
    }

    public String tabs() {
        return tabs(0);
    }

    public String tabs(int increment) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tabular + increment; i++) {
            builder.append(baseTabulator);
        }
        return builder.toString();
    }

    public String indent() {
        tabular++;
        return tabs();
    }

    public String unindent() {
        tabular--;
        return tabs();
    }
}
