package org.shinar.adapter.java.analyzer;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.shinar.neutral.representation.NeutralCodeUnit;
import org.shinar.neutral.representation.NeutralTypeDeclaration;
import org.shinar.neutral.representation.statement.*;
import org.shinar.neutral.representation.statement.Statement;
import org.shinar.neutral.representation.statement.TypeDeclaration;
import org.shinar.neutral.representation.statement.VariableDeclaration;
import org.shinar.utils.MultiMethod;
import org.shinar.utils.NoDispatchedMethod;

import java.util.List;

/**
 * Created by marco on 21/06/14.
 */
public class StatementAnalyzer {
    public static Statement analyze(org.eclipse.jdt.core.dom.Statement statement) {
        try {
            return (Statement) MultiMethod.redispatchStatic(statement);
        } catch (NoDispatchedMethod e) {
            throw new RuntimeException(e);
        }
    }

    public static CodeBlock analyze(Block block) {
        CodeBlock result = new CodeBlock();
        for (org.eclipse.jdt.core.dom.Statement statement : (List<org.eclipse.jdt.core.dom.Statement>) block.statements()) {
            result.getStatements().add(StatementAnalyzer.analyze(statement));
        }
        return result;
    }

    public static Assert analyze(AssertStatement statement) {
        Assert result = new Assert();
        result.setExpression(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setMessage(ExpressionAnalyzer.analyze(statement.getMessage()));
        return result;
    }

    public static Break analyze(BreakStatement statement) {
        Break result = new Break();
        result.setLabel(statement.getLabel().getIdentifier());
        return result;
    }

    public static Continue analyze(ContinueStatement statement) {
        Continue result = new Continue();
        result.setLabel(statement.getLabel().getIdentifier());
        return result;
    }

    public static Do analyze(DoStatement statement) {
        Do result = new Do();
        result.setCondition(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setBlock(StatementAnalyzer.analyze(statement.getBody()));
        return result;
    }

    public static Empty analyze(EmptyStatement statement) {
        Empty result = new Empty();
        return result;
    }

    public static CodeExpression analyze(ExpressionStatement statement) {
        //TODO: Expressions are
        CodeExpression result = new CodeExpression();
        result.setExpression(ExpressionAnalyzer.analyze(statement.getExpression()));
        return result;
    }

    public static EnhancedFor analyze(EnhancedForStatement statement) {
        EnhancedFor result = new EnhancedFor();
        result.setBlock((CodeBlock) StatementAnalyzer.analyze(statement.getBody()));
        result.setGenerator(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setParameters(StatementAnalyzer.analyze(statement.getParameter()));
        return result;
    }

    public static For analyze(ForStatement statement) {
        For result = new For();
        result.setCondition(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setBlock((CodeBlock) StatementAnalyzer.analyze(statement.getBody()));
        for (Expression initializer : (List<Expression>) statement.initializers()) {
            result.getInitializers().add(ExpressionAnalyzer.analyze(initializer));
        }
        for (Expression updater : (List<Expression>) statement.updaters()) {
            result.getUpdaters().add(ExpressionAnalyzer.analyze(updater));
        }
        return result;
    }

    public static If analyze(IfStatement statement) {
        If result = new If();
        result.setCondition(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setThenBlock(StatementAnalyzer.analyze(statement.getThenStatement()));
        result.setFalseBlock(StatementAnalyzer.analyze(statement.getElseStatement()));
        return result;
    }

    public static Labeled analyze(LabeledStatement statement) {
        Labeled result = new Labeled();
        result.setLabel(statement.getLabel().getIdentifier());
        result.setBlock((CodeBlock) StatementAnalyzer.analyze(statement.getBody()));
        return result;
    }

    public static Return analyze(ReturnStatement statement) {
        Return result = new Return();
        result.setExpression(ExpressionAnalyzer.analyze(statement.getExpression()));
        return result;
    }

    protected static long switchCounter = 1;

    public static Statement analyze(SwitchStatement statement) {
        //TODO: Fix and improve
        Block block = statement.getAST().newBlock();
        //switch_condition_1 = <condition>;
        SingleVariableDeclaration declaration = block.getAST().newSingleVariableDeclaration();
        SimpleName conditionName = block.getAST().newSimpleName("switch_condition_" + switchCounter);
        declaration.setName(conditionName);
        declaration.setInitializer(statement.getExpression());
        block.statements().add(declaration);
        //while(true)
        WhileStatement whileStatement = statement.getAST().newWhileStatement();
        whileStatement.setExpression(whileStatement.getAST().newBooleanLiteral(true));
        block.statements().add(whileStatement);
        //{
        Block whileBlock = whileStatement.getAST().newBlock();
        whileStatement.setBody(whileBlock);
        IfStatement lastIfStatement = null;
        boolean isDefault = false;
        //for (Statement caseBlock : (List<Statement>) statement.statements()) {
        for(int i =0; i<statement.statements().size(); i++){
            Statement switchStatement = (Statement) statement.statements().get(i);
            if (switchStatement instanceof SwitchCase) {
                SwitchCase switchCase = (SwitchCase) switchStatement;
                if (!switchCase.isDefault()) {
                    IfStatement ifStatement = whileBlock.getAST().newIfStatement();
                    InfixExpression conditional = ifStatement.getAST().newInfixExpression();
                    conditional.setLeftOperand(conditionName);
                    conditional.setOperator(InfixExpression.Operator.EQUALS);
                    conditional.setRightOperand(switchCase.getExpression());
                    ifStatement.setExpression(conditional);
                    ifStatement.setThenStatement(ifStatement.getAST().newBlock());
                    if(i!=0 && !(statement.statements().get(i-1) instanceof BreakStatement) ){
                        Assignment assignment = whileStatement.getAST().newAssignment();
                        //assignment.getLeftHandSide(whileStatement.getAST().newName());
                        assignment.setLeftHandSide(conditionName);
                        assignment.setRightHandSide(switchCase.getExpression());
                        lastIfStatement.setExpression(assignment);
                    }
                    if (lastIfStatement != null) {
                        lastIfStatement.setElseStatement(ifStatement);
                    }
                    lastIfStatement = ifStatement;
                    isDefault = false;
                } else {
                    isDefault = true;
                    if(lastIfStatement==null){
                        lastIfStatement=whileBlock.getAST().newIfStatement();
                        lastIfStatement.setExpression(whileStatement.getAST().newBooleanLiteral(false));
                        lastIfStatement.setThenStatement(lastIfStatement.getAST().newBlock());
                    }
                    lastIfStatement.setElseStatement(lastIfStatement .getAST().newBlock());
                }
            } else {
                Block currentBlock = (Block) (isDefault? lastIfStatement.getElseStatement(): lastIfStatement.getThenStatement());
                currentBlock.statements().add(switchStatement);
            }
        }
        if(lastIfStatement!=null){
            whileBlock.statements().add(lastIfStatement);
        }
        switchCounter++;
        return StatementAnalyzer.analyze(block);
    }

    public static Throw analyze(ThrowStatement statement) {
        Throw result = new Throw();
        result.setExpression(ExpressionAnalyzer.analyze(statement.getExpression()));
        return result;
    }

    private static Try analyzeTry(TryStatement statement) {
        Try result = new Try();
        result.setTryBlock(StatementAnalyzer.analyze(statement.getBody()));
        result.setFinallyBlock(StatementAnalyzer.analyze(statement.getFinally()));
        for (CatchClause clause : (List<CatchClause>) statement.catchClauses()) {
            TryCatch tryCatch = new TryCatch();
            tryCatch.setExceptions(StatementAnalyzer.analyze(clause.getException()));
            tryCatch.setBlock(StatementAnalyzer.analyze(clause.getBody()));
            result.getCatches().add(tryCatch);
        }
        return result;
    }

    public static Statement analyze(TryStatement statement) {
        if (statement.resources().size() == 0) {
            return analyzeTry(statement);
        } else {
            //TRICK:
            /*
            try(AutoCloseable object = Something()){
            }
            catch(Exception e){...}
            finally{...}
            ==>
            try(AutoCloseable object = Something()){
                try{...}
                catch(Exception e){...}
                finally{...}
            }
             */
            With result = new With();
            CodeBlock block;
            for (VariableDeclarationExpression declaration : (List<VariableDeclarationExpression>) statement.resources()) {
                result.getResources().add(ExpressionAnalyzer.analyze(declaration));
            }
            if (statement.catchClauses().size() > 0 || statement.getFinally() != null) {
                //Do transformation:
                block = new CodeBlock();
                block.getStatements().add(analyzeTry(statement));
            } else {
                block = StatementAnalyzer.analyze(statement.getBody());
            }
            result.setBlock(block);
            return result;
        }
    }

    public static NeutralCodeUnit analyze(TypeDeclarationStatement statement) {
        //TODO: Add logic of "Inner classes"
        return TypeAnalyzer.analyze(statement.getDeclaration());
    }

    public static VariableDeclaration analyzeVariable(Type type, VariableDeclarationFragment fragment) {
        VariableDeclaration variableDeclaration = new VariableDeclaration();
        variableDeclaration.setName(fragment.getName().toString());
        variableDeclaration.setType(CodeUnitAnalyzer.classTypeData(type));
        variableDeclaration.setDefaultExpression(ExpressionAnalyzer.analyze(fragment.getInitializer()));
        return variableDeclaration;
    }

    public static ListVariableDeclaration analyze(VariableDeclarationStatement statement) {
        //TODO: Modifiers!
        ListVariableDeclaration result = new ListVariableDeclaration();
        for (VariableDeclarationFragment fragment : (List<VariableDeclarationFragment>) statement.fragments()) {
            VariableDeclaration variableDeclaration = new VariableDeclaration();
            variableDeclaration.setName(fragment.getName().toString());
            variableDeclaration.setType(CodeUnitAnalyzer.classTypeData(statement.getType()));
            variableDeclaration.setDefaultExpression(ExpressionAnalyzer.analyze(fragment.getInitializer()));
            result.getVariables().add(variableDeclaration);
        }
        return result;
    }

    public static ListVariableDeclaration analyze(SingleVariableDeclaration statement) {
        //TODO: Modifiers!
        ListVariableDeclaration result = new ListVariableDeclaration();
        VariableDeclaration variableDeclaration = new VariableDeclaration();
        variableDeclaration.setName(statement.getName().toString());
        variableDeclaration.setType(CodeUnitAnalyzer.classTypeData(statement.getType()));
        variableDeclaration.setDefaultExpression(ExpressionAnalyzer.analyze(statement.getInitializer()));
        variableDeclaration.setUnknownLength(statement.isVarargs());
        result.getVariables().add(variableDeclaration);
        return result;
    }

    public static While analyze(WhileStatement statement) {
        While result = new While();
        result.setCondition(ExpressionAnalyzer.analyze(statement.getExpression()));
        result.setBlock(StatementAnalyzer.analyze(statement.getBody()));
        return result;
    }


}
