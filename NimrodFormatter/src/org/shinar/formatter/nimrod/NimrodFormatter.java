package org.shinar.formatter.nimrod;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mvel.templates.TemplateRuntime;
import org.shinar.formatter.neutral.BaseFormatter;
import org.shinar.neutral.representation.*;
import org.shinar.neutral.representation.expression.*;
import org.shinar.neutral.representation.statement.*;
import org.shinar.utils.InfiniteRecursionWarning;
import org.shinar.utils.MultiMethod;

import java.util.HashMap;

/**
 * Created by marco on 18/06/14.
 */
@Data
public class NimrodFormatter implements BaseFormatter {
    @Setter(AccessLevel.PROTECTED)
    private int tabular = 0;

    private String tabs() {
        return tabs(0);
    }

    private String tabs(int increment) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tabular + increment; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    private void commonParameters(HashMap<String, Object> map, NeutralObject object){
        map.put("tabs", tabs());
        map.put("name", object.getName());
        map.put("visibility", object.getVisibility() == ObjectVisibility.Public ? "*" : "");
    }

    @Override
    @MultiMethod
    public String format(NeutralObject object) {
        try {
            return (String) MultiMethod.Apply.invoke(this, object);
        } catch (InfiniteRecursionWarning infiniteRecursionWarning) {
            throw new RuntimeException("No format available! " + object.getClass().toString());
        }
    }

    @Override
    public String format(CodeGroup codeGroup) {
        //TODO: Improve format of code groups!
        StringBuilder result = new StringBuilder();
        for (NeutralCodeUnit unit : codeGroup.getUnits()) {
            result.append(format(unit));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String format(NeutralClass classObject) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        commonParameters(map, classObject);
        //map.put("ancestor", "TObject");
        map.put("ancestor", classObject.getParents().size() > 0 ? classObject.getParents().get(0).getName() : "TObject");
        StringBuilder code = new StringBuilder((String) TemplateRuntime.eval(
                "@{tabs}type @{name}@{visibility} = object of @{ancestor}\n",
                map));
        tabular++;
        for (Field field : classObject.getFields()) {
            //field.getCode(this);
            code.append(format(field));
        }
        tabular--;
        for (Method method : classObject.getMethods()) {
            code.append(format(method));
        }
        //TODO: Inner classes!
        return code.toString();
    }

    @Override
    public String format(NeutralInterface interfaceObject) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        commonParameters(map, interfaceObject);
        //map.put("ancestor", "TObject");
        map.put("ancestor", interfaceObject.getParents().size() > 0 ? interfaceObject.getParents().get(0).getName() : "TObject");
        StringBuilder code = new StringBuilder((String) TemplateRuntime.eval(
                "@{tabs}type @{name}@{visibility} = object of @{ancestor}\n",
                map));
        tabular++;
        for (Field field : interfaceObject.getFields()) {
            //field.getCode(this);
            code.append(format(field));
        }
        tabular--;
        return code.toString();
    }

    @Override
    public String format(NeutralEnumeration object) {
        return null;
    }


    @Override
    public String format(Field field) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        commonParameters(map, field);
        map.put("type", (field.getType().isPrimitive() ? "ref " : "") + field.getType().getName());
        String code = (String) TemplateRuntime.eval(
                "@{tabs}@{name}@{visibility}: @{type}\n",
                map);
        return code;
    }

    @Override
    public String format(Method method) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        commonParameters(map, method);
        map.put("return_type", (method.getReturnType().isPrimitive() ? "ref " : "") + method.getReturnType().getName());
        map.put("params", "");
        String code = (String) TemplateRuntime.eval(
                "@{tabs}proc @{name}@{visibility}(@{params}): @{return_type}=\n",
                map);
        return code;
    }


    @Override
    public String format(Import object) {
        return null;
    }

    /*Statements formatter*/

    @Override
    public String format(Statement object) {
        throw new RuntimeException("No format available! " + object.getClass().toString());
        /*try {
            return (String)MultiMethod.redispatch(this, object);
        }catch(InfiniteRecursionWarning e){
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public String format(Assert object) {
        return null;
    }

    @Override
    public String format(Break object) {
        return null;
    }

    @Override
    public String format(CodeBlock object) {
        return null;
    }

    @Override
    public String format(CodeExpression object) {
        return null;
    }

    @Override
    public String format(Continue object) {
        return null;
    }

    @Override
    public String format(Do object) {
        return null;
    }

    @Override
    public String format(Empty object) {
        return null;
    }

    @Override
    public String format(EnhancedFor object) {
        return null;
    }

    @Override
    public String format(For object) {
        return null;
    }

    @Override
    public String format(If object) {
        return null;
    }

    @Override
    public String format(Labeled object) {
        return null;
    }

    @Override
    public String format(ListVariableDeclaration object) {
        return null;
    }

    @Override
    public String format(Return object) {
        return null;
    }

    @Override
    public String format(Switch object) {
        return null;
    }

    @Override
    public String format(Throw object) {
        return null;
    }

    @Override
    public String format(TryCatch object) {
        return null;
    }

    @Override
    public String format(Try object) {
        return null;
    }

    @Override
    public String format(TypeDeclaration object) {
        return null;
    }

    @Override
    public String format(VariableDeclaration object) {
        return null;
    }

    @Override
    public String format(VariableModifier object) {
        return null;
    }

    @Override
    public String format(While object) {
        return null;
    }

    @Override
    public String format(With object) {
        return null;
    }


    /*Expressions formatter*/

    @Override
    public String format(Expression object) {
        throw new RuntimeException("No format available! " + object.getClass().toString());
        /*try {
            return (String)MultiMethod.redispatch(this, object);
        }catch(InfiniteRecursionWarning e){
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public String format(ArrayAccess object) {
        return null;
    }

    @Override
    public String format(Array object) {
        return null;
    }

    @Override
    public String format(Assignment object) {
        return null;
    }

    @Override
    public String format(BooleanLiteral object) {
        return null;
    }

    @Override
    public String format(Cast object) {
        return null;
    }

    @Override
    public String format(CharacterLiteral object) {
        return null;
    }

    @Override
    public String format(Conditional object) {
        return null;
    }

    @Override
    public String format(FieldAccess object) {
        return null;
    }

    @Override
    public String format(InfixOperation object) {
        return null;
    }

    @Override
    public String format(Instanceof object) {
        return null;
    }

    @Override
    public String format(Literal object) {
        return null;
    }

    @Override
    public String format(MethodCall object) {
        return null;
    }

    @Override
    public String format(Name object) {
        return null;
    }

    @Override
    public String format(NullLiteral object) {
        return null;
    }

    @Override
    public String format(NumberLiteral object) {
        return null;
    }

    @Override
    public String format(Parenthesized object) {
        return null;
    }

    @Override
    public String format(PostfixOperation object) {
        return null;
    }

    @Override
    public String format(PrefixOperation object) {
        return null;
    }

    @Override
    public String format(StringLiteral object) {
        return null;
    }

    @Override
    public String format(SuperFieldAccess object) {
        return null;
    }

    @Override
    public String format(SuperMethodCall object) {
        return null;
    }

    @Override
    public String format(This object) {
        return null;
    }

    @Override
    public String format(TypeLiteral object) {
        return null;
    }
}
