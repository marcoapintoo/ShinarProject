package org.shinar.formatter.neutral;

import org.shinar.neutral.representation.*;
import org.shinar.neutral.representation.expression.*;
import org.shinar.neutral.representation.statement.*;

/**
 * Created by marco on 18/06/14.
 */
public interface BaseFormatter {
    String format(NeutralObject object);

    String format(CodeGroup object);

    String format(NeutralClass object);

    String format(NeutralEnumeration object);

    String format(NeutralInterface object);

    String format(Method object);

    String format(Field object);

    String format(Import object);

    String format(Statement object);

    String format(Assert object);

    String format(Break object);

    String format(CodeBlock object);

    String format(CodeExpression object);

    String format(Continue object);

    String format(Do object);

    String format(Empty object);

    String format(EnhancedFor object);

    String format(For object);

    String format(If object);

    String format(Labeled object);

    String format(ListVariableDeclaration object);

    String format(Return object);

    String format(Switch object);

    String format(Throw object);

    String format(TryCatch object);

    String format(Try object);

    String format(TypeDeclaration object);

    String format(VariableDeclaration object);

    String format(VariableModifier object);

    String format(While object);

    String format(With object);

    String format(Expression object);

    String format(ArrayAccess object);

    String format(Array object);

    String format(Assignment object);

    String format(BooleanLiteral object);

    String format(Cast object);

    String format(CharacterLiteral object);

    String format(Conditional object);

    String format(FieldAccess object);

    String format(InfixOperation object);

    String format(Instanceof object);

    String format(Literal object);

    String format(MethodCall object);

    String format(Name object);

    String format(NullLiteral object);

    String format(NumberLiteral object);

    String format(Parenthesized object);

    String format(PostfixOperation object);

    String format(PrefixOperation object);

    String format(StringLiteral object);

    String format(SuperFieldAccess object);

    String format(SuperMethodCall object);

    String format(This object);

    String format(TypeLiteral object);
}
