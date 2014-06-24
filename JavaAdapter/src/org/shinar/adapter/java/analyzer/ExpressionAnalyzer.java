package org.shinar.adapter.java.analyzer;

import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.jdt.core.dom.*;
import org.shinar.neutral.representation.Directory;
import org.shinar.neutral.representation.expression.*;
import org.shinar.neutral.representation.expression.ArrayAccess;
import org.shinar.neutral.representation.expression.Assignment;
import org.shinar.neutral.representation.expression.BooleanLiteral;
import org.shinar.neutral.representation.expression.CharacterLiteral;
import org.shinar.neutral.representation.expression.Expression;
import org.shinar.neutral.representation.expression.FieldAccess;
import org.shinar.neutral.representation.expression.Name;
import org.shinar.neutral.representation.expression.NullLiteral;
import org.shinar.neutral.representation.expression.NumberLiteral;
import org.shinar.neutral.representation.expression.StringLiteral;
import org.shinar.neutral.representation.expression.SuperFieldAccess;
import org.shinar.neutral.representation.expression.TypeLiteral;
import org.shinar.neutral.representation.statement.*;
import org.shinar.neutral.representation.statement.VariableDeclaration;
import org.shinar.utils.MultiMethod;
import org.shinar.utils.NoDispatchedMethod;

import java.util.EnumSet;
import java.util.List;

/**
 * Created by marco on 22/06/14.
 */
public class ExpressionAnalyzer {

    public static Expression analyze(org.eclipse.jdt.core.dom.Expression expression) {
        try {
            return (Expression) MultiMethod.redispatchStatic(expression);
        } catch (NoDispatchedMethod e) {
            throw new RuntimeException(e);
        }
    }

    public static Cast analyze(CastExpression expression) {
        Cast result = new Cast();
        result.setExpression(ExpressionAnalyzer.analyze(expression.getExpression()));
        result.setTargetType(ClassAnalyzer.classTypeData(expression.getType()));
        return result;
    }

    public static Conditional analyze(ConditionalExpression expression) {
        Conditional result = new Conditional();
        result.setCondition(ExpressionAnalyzer.analyze(expression.getExpression()));
        result.setTrueExpression(ExpressionAnalyzer.analyze(expression.getThenExpression()));
        result.setFalseExpression(ExpressionAnalyzer.analyze(expression.getElseExpression()));
        return result;
    }

    public static PrefixOperation.Operator analyze(PrefixExpression.Operator operator) {
        if (operator == PrefixExpression.Operator.COMPLEMENT) {
            return PrefixOperation.Operator.Complement;
        } else if (operator == PrefixExpression.Operator.DECREMENT) {
            return PrefixOperation.Operator.AutoDecrement;
        } else if (operator == PrefixExpression.Operator.INCREMENT) {
            return PrefixOperation.Operator.AutoIncrement;
        } else if (operator == PrefixExpression.Operator.MINUS) {
            return PrefixOperation.Operator.Minus;
        } else if (operator == PrefixExpression.Operator.PLUS) {
            return PrefixOperation.Operator.Plus;
        } else if (operator == PrefixExpression.Operator.NOT) {
            return PrefixOperation.Operator.Not;
        } else {
            throw new RuntimeException("Unknown prefix operator!");
        }
    }

    public static PostfixOperation.Operator analyze(PostfixExpression.Operator operator) {
        if (operator == PostfixExpression.Operator.DECREMENT) {
            return PostfixOperation.Operator.AutoDecrement;
        } else if (operator == PostfixExpression.Operator.INCREMENT) {
            return PostfixOperation.Operator.AutoIncrement;
        } else {
            throw new RuntimeException("Unknown postfix operator!");
        }
    }

    public static InfixOperation.Operator analyze(InfixExpression.Operator operator) {
        if (operator == InfixExpression.Operator.TIMES) {
            return InfixOperation.Operator.Times;
        } else if (operator == InfixExpression.Operator.DIVIDE) {
            return InfixOperation.Operator.Divide;
        } else if (operator == InfixExpression.Operator.REMAINDER) {
            return InfixOperation.Operator.Remainder;
        } else if (operator == InfixExpression.Operator.PLUS) {
            return InfixOperation.Operator.Plus;
        } else if (operator == InfixExpression.Operator.MINUS) {
            return InfixOperation.Operator.Minus;
        } else if (operator == InfixExpression.Operator.LEFT_SHIFT) {
            return InfixOperation.Operator.LeftShift;
        } else if (operator == InfixExpression.Operator.RIGHT_SHIFT_SIGNED) {
            return InfixOperation.Operator.RightShift;
        } else if (operator == InfixExpression.Operator.RIGHT_SHIFT_UNSIGNED) {
            return InfixOperation.Operator.TripleGreaterShift;
        } else if (operator == InfixExpression.Operator.LESS) {
            return InfixOperation.Operator.Less;
        } else if (operator == InfixExpression.Operator.GREATER) {
            return InfixOperation.Operator.Greater;
        } else if (operator == InfixExpression.Operator.LESS_EQUALS) {
            return InfixOperation.Operator.LessOrEquals;
        } else if (operator == InfixExpression.Operator.GREATER_EQUALS) {
            return InfixOperation.Operator.GreaterOrEquals;
        } else if (operator == InfixExpression.Operator.EQUALS) {
            return InfixOperation.Operator.Equals;
        } else if (operator == InfixExpression.Operator.NOT_EQUALS) {
            return InfixOperation.Operator.NotEquals;
        } else if (operator == InfixExpression.Operator.XOR) {
            return InfixOperation.Operator.BinaryXor;
        } else if (operator == InfixExpression.Operator.OR) {
            return InfixOperation.Operator.BinaryOr;
        } else if (operator == InfixExpression.Operator.AND) {
            return InfixOperation.Operator.BinaryAnd;
        } else if (operator == InfixExpression.Operator.CONDITIONAL_OR) {
            return InfixOperation.Operator.Or;
        } else if (operator == InfixExpression.Operator.CONDITIONAL_AND) {
            return InfixOperation.Operator.And;
        } else {
            throw new RuntimeException("Unknown infix operator!");
        }
    }

    public static PrefixOperation analyze(PrefixExpression expression) {
        PrefixOperation result = new PrefixOperation();
        result.setOperand(ExpressionAnalyzer.analyze(expression.getOperand()));
        result.setOperator(ExpressionAnalyzer.analyze(expression.getOperator()));
        return result;
    }

    public static InfixOperation analyze(InfixExpression expression) {
        InfixOperation result = new InfixOperation();
        result.setOperator(ExpressionAnalyzer.analyze(expression.getOperator()));
        result.setLeftOperand(ExpressionAnalyzer.analyze(expression.getLeftOperand()));
        result.setRightOperand(ExpressionAnalyzer.analyze(expression.getRightOperand()));
        if (expression.hasExtendedOperands()) {
            for (org.eclipse.jdt.core.dom.Expression e : (List<org.eclipse.jdt.core.dom.Expression>) expression.extendedOperands()) {
                result.getOtherOperands().add(ExpressionAnalyzer.analyze(e));
            }
        }
        return result;
    }

    public static PostfixOperation analyze(PostfixExpression expression) {
        PostfixOperation result = new PostfixOperation();
        result.setOperand(ExpressionAnalyzer.analyze(expression.getOperand()));
        result.setOperator(ExpressionAnalyzer.analyze(expression.getOperator()));
        return result;
    }

    public static Instanceof analyze(InstanceofExpression expression) {
        Instanceof result = new Instanceof();
        result.setExpression(ExpressionAnalyzer.analyze(expression.getLeftOperand()));
        result.setType(CodeUnitAnalyzer.classTypeData(expression.getRightOperand()));
        return result;
    }

    public static Parenthesized analyze(ParenthesizedExpression expression) {
        Parenthesized result = new Parenthesized();
        result.setExpression(ExpressionAnalyzer.analyze(expression.getExpression()));
        return result;
    }

    public static This analyze(ThisExpression expression) {
        This result = new This();
        if (expression.getQualifier() != null) {
            result.setNamespace(Directory.of(expression.getQualifier().toString()));
        }
        return result;
    }

    public static ListVariableDeclaration analyze(VariableDeclarationExpression expression) {
        ListVariableDeclaration result = new ListVariableDeclaration();
        EnumSet<VariableModifier> modifiers = EnumSet.noneOf(VariableModifier.class);
        for (IExtendedModifier modifier : (List<IExtendedModifier>) expression.modifiers()) {
            if (modifier instanceof Modifier) {
                //Final is the only meaningful modifier in Java
                if (((Modifier) modifier).isFinal()) {
                    modifiers.add(VariableModifier.Final);
                }
            }
        }
        for (VariableDeclarationFragment fragment : (List<VariableDeclarationFragment>) expression.fragments()) {
            VariableDeclaration variableDeclaration = StatementAnalyzer.analyzeVariable(expression.getType(), fragment);
            variableDeclaration.setModifiers(modifiers);
            result.getVariables().add(variableDeclaration);
        }
        return result;
    }



    public static Expression analyze(Annotation expression) {
        //TODO: Handle java annotations
        return null;
    }

    public static ArrayAccess analyze(org.eclipse.jdt.core.dom.ArrayAccess expression) {
        ArrayAccess result = new ArrayAccess();
        result.setArray(ExpressionAnalyzer.analyze(expression.getArray()));
        result.setIndex(ExpressionAnalyzer.analyze(expression.getIndex()));
        return result;
    }

    public static While analyze(ArrayCreation expression) {
        return null;
    }

    public static Array analyze(ArrayInitializer expression) {
        Array result = new Array();
        for(org.eclipse.jdt.core.dom.Expression e: (List<org.eclipse.jdt.core.dom.Expression>) expression.expressions() ){
            result.getElements().add(ExpressionAnalyzer.analyze(e));
        }
        return result;
    }

    public static Assignment.Operator analyze(org.eclipse.jdt.core.dom.Assignment.Operator operator) {
        if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.ASSIGN) {
            return Assignment.Operator.Assign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.PLUS_ASSIGN) {
            return Assignment.Operator.PlusAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.MINUS_ASSIGN) {
            return Assignment.Operator.MinusAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.TIMES_ASSIGN) {
            return Assignment.Operator.TimesAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.DIVIDE_ASSIGN) {
            return Assignment.Operator.DivideAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.BIT_AND_ASSIGN) {
            return Assignment.Operator.BinaryAndAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.BIT_OR_ASSIGN) {
            return Assignment.Operator.BinaryOrAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.BIT_XOR_ASSIGN) {
            return Assignment.Operator.BinaryXorAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.REMAINDER_ASSIGN) {
            return Assignment.Operator.RemainderAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.LEFT_SHIFT_ASSIGN) {
            return Assignment.Operator.LeftShiftAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.RIGHT_SHIFT_SIGNED_ASSIGN) {
            return Assignment.Operator.RightShiftAssign;
        } else if (operator == org.eclipse.jdt.core.dom.Assignment.Operator.RIGHT_SHIFT_UNSIGNED_ASSIGN) {
            return Assignment.Operator.TripleRightShiftAssign;
        } else {
            throw new RuntimeException("Unknown infix operator!");
        }
    }

    public static Assignment analyze(org.eclipse.jdt.core.dom.Assignment expression) {
        Assignment result = new Assignment();
        result.setLeftExpression(ExpressionAnalyzer.analyze(expression.getLeftHandSide()));
        result.setOperator(ExpressionAnalyzer.analyze(expression.getOperator()));
        result.setRightExpression(ExpressionAnalyzer.analyze(expression.getRightHandSide()));
        return result;
    }

    public static BooleanLiteral analyze(org.eclipse.jdt.core.dom.BooleanLiteral expression) {
        BooleanLiteral result=new BooleanLiteral();
        result.setValue(expression.booleanValue());
        return result;
    }

    public static CharacterLiteral analyze(org.eclipse.jdt.core.dom.CharacterLiteral expression) {
        CharacterLiteral result = new CharacterLiteral();
        result.setValue(expression.charValue()+"");
        result.setEscapedValue(expression.getEscapedValue());
        return result;
    }

    public static While analyze(ClassInstanceCreation expression) {
        //TODO: AnonymousClasses
        //http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjdt%2Fcore%2Fdom%2FClassInstanceCreation.html
        return null;
    }

    public static FieldAccess analyze(org.eclipse.jdt.core.dom.FieldAccess expression) {
        FieldAccess result = new FieldAccess();
        result.setExpression(ExpressionAnalyzer.analyze(expression.getExpression()));
        result.setField(expression.getName().getIdentifier().toString());
        return result;
    }

    public static MethodCall analyze(MethodInvocation expression) {
        MethodCall result = new MethodCall();
        result.setExpression(ExpressionAnalyzer.analyze(expression.getExpression()));
        result.setMethodName(expression.getName().getIdentifier().toString());
        //TODO: Type arguments in java
        for (org.eclipse.jdt.core.dom.Expression e : (List<org.eclipse.jdt.core.dom.Expression>) expression.arguments()) {
            result.getArguments().add(ExpressionAnalyzer.analyze(e));
        }
        return result;
    }

    public static Name analyze(org.eclipse.jdt.core.dom.Name expression) {
        return Name.of(expression.getFullyQualifiedName());
    }
    public static Name analyze(SimpleName expression) {
        return Name.of(expression.getFullyQualifiedName());
    }
    public static Name analyze(QualifiedName expression) {
        return Name.of(expression.getFullyQualifiedName());
    }

    public static NullLiteral analyze(org.eclipse.jdt.core.dom.NullLiteral expression) {
        return new NullLiteral();
    }

    public static NumberLiteral analyze(org.eclipse.jdt.core.dom.NumberLiteral expression) {
        NumberLiteral result = new NumberLiteral();
        result.setValue(NumberUtils.createNumber(expression.getToken()));
        return result;
    }

    public static StringLiteral analyze(org.eclipse.jdt.core.dom.StringLiteral expression) {
        StringLiteral result = new StringLiteral();
        result.setValue(expression.getLiteralValue());
        result.setEscapedValue(expression.getEscapedValue());
        return result;
    }

    public static SuperFieldAccess analyze(org.eclipse.jdt.core.dom.SuperFieldAccess expression) {
        SuperFieldAccess result = new SuperFieldAccess();
        if (expression.getQualifier() != null) {
            result.setNamespace(Directory.of(expression.getQualifier().getFullyQualifiedName()));
        }
        result.setField(expression.getName().toString());
        return result;
    }

    public static SuperMethodCall analyze(SuperMethodInvocation expression) {
        SuperMethodCall result = new SuperMethodCall();
        if (expression.getQualifier() != null) {
            result.setNamespace(Directory.of(expression.getQualifier().getFullyQualifiedName()));
        }
        result.setMethodName(expression.getName().getIdentifier().toString());
        //TODO: Type arguments in java
        for (org.eclipse.jdt.core.dom.Expression e : (List<org.eclipse.jdt.core.dom.Expression>) expression.arguments()) {
            result.getArguments().add(ExpressionAnalyzer.analyze(e));
        }
        return result;
    }

    public static TypeLiteral analyze(org.eclipse.jdt.core.dom.TypeLiteral expression) {
        TypeLiteral result = new TypeLiteral();
        result.setValue(CodeUnitAnalyzer.classTypeData(expression.getType()));
        return result;
    }
}
