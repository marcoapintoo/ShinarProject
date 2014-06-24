package org.shinar.formatter.nimrod;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mvel.templates.TemplateRuntime;
import org.shinar.neutral.representation.*;

import java.util.HashMap;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class CodeFormatter implements Formatter {
    @Setter(AccessLevel.PROTECTED) private int tabular = 0;
    /*private NeutralReflector reflector;
    public String formatClass(Object object){
        NeutralCodeUnit baseclass = new NeutralCodeUnit();
        NeutralClass klazz = (NeutralClass) reflector.traverseClass((Class<?>)object);
        return format(klazz);
    }*/

    @Override
    public String format(NeutralObject object) {
        return "";
    }

    public String format(NeutralClass klazz){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("tabs", tabs(0));
        map.put("visibility", klazz.getVisibility()== ObjectVisibility.Public? "*":"");
        map.put("methodName", klazz.getName());
        //map.put("ancestor", "TObject");
        map.put("ancestor", klazz.getParents().size()>0?klazz.getParents().get(0).getName(): "TObject");
        StringBuilder code = new StringBuilder((String) TemplateRuntime.eval(
                "@{tabs}type @{methodName}@{visibility} = object of @{ancestor}\n",
                map));
        tabular++;
        for(Field field: klazz.getFields()){
            code.append(format(field));
        }
        tabular--;
        for(Method method: klazz.getMethods()){
            code.append(format(method));
        }
        return code.toString();
    }

    public String format(Field field){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("tabs", tabs(0));
        map.put("visibility", field.getVisibility()== ObjectVisibility.Public? "*":"");
        map.put("methodName", field.getName());
        map.put("type", (field.getType().isPrimitive()? "ref ": "") + field.getType().getName());
        String code = (String) TemplateRuntime.eval(
                "@{tabs}@{methodName}@{visibility}: @{type}\n",
                map);
        return code;
    }

    public String format(Method method){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("tabs", tabs(0));
        map.put("visibility", method.getVisibility()== ObjectVisibility.Public? "*":"");
        map.put("methodName", method.getName());
        map.put("return_type", (method.getReturnType().isPrimitive()? "ref ": "")+method.getReturnType().getName());
        map.put("params", "");
        String code = (String) TemplateRuntime.eval(
                "@{tabs}proc @{methodName}@{visibility}(@{params}): @{return_type}=\n",
                map);
        return code;
    }

    private String tabs(int increment){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < tabular + increment; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }
}
