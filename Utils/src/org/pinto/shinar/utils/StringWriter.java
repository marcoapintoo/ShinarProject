package org.pinto.shinar.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by marco on 01/07/14.
 */
@Data
public class StringWriter implements IOutputWriter {
    @Setter(AccessLevel.PROTECTED)
    private StringBuilder builder = new StringBuilder();
    private Tabulator tabulator = new Tabulator();

    @Override
    public IOutputWriter append(String object) {
        builder.append(object);
        return this;
    }

    @Override
    public IOutputWriter append(Object object) {
        builder.append(object.toString());
        return this;
    }

    @Override
    public IOutputWriter newline() {
        builder.append("\n");
        return this;
    }

    @Override
    public IOutputWriter indent() {
        builder.append(tabulator.indent());
        return this;
    }

    @Override
    public IOutputWriter newlineindented() {
        newline().indent();
        return this;
    }

    @Override
    public IOutputWriter unindent() {
        builder.append(tabulator.unindent());
        return this;
    }

    @Override
    public IOutputWriter newlineunindented() {
        newline().unindent();
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
