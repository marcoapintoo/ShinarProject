package org.pinto.shinar.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mvel.templates.TemplateRuntime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marco on 30/06/14.
 */
@Data
public class StringTemplate {
    @Setter(AccessLevel.PROTECTED)
    private Map<String, String> parameters = new HashMap<String, String>();
    private String template = "";

    public StringTemplate() {
    }

    public static StringTemplate of(String template) {
        StringTemplate stringTemplate = new StringTemplate();
        stringTemplate.setTemplate(template);
        return stringTemplate;
    }

    public static String of(String template, String... values) {
        StringTemplate stringTemplate = new StringTemplate();
        stringTemplate.setTemplate(template);
        stringTemplate.put(values);
        return stringTemplate.eval();
    }

    public StringTemplate put(String key, Object value) {
        parameters.put(key, value.toString());
        return this;
    }

    public StringTemplate put(Map<? extends String, ? extends String> values) {
        parameters.putAll(values);
        return this;
    }

    public StringTemplate put(String... values) {
        if (values.length % 2 == 1) {
            throw new RuntimeException("String template parameters are incorrect!");
        }
        for (int i = 0; i < values.length; i += 2) {
            put(values[i], values[i + 1]);
        }
        return this;
    }

    public String eval() {
        return (String) TemplateRuntime.eval(template, parameters);
    }
}
