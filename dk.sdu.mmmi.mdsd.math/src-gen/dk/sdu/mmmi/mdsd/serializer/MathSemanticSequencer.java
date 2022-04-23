/*
 * generated by Xtext 2.26.0
 */
package dk.sdu.mmmi.mdsd.serializer;

import com.google.inject.Inject;
import dk.sdu.mmmi.mdsd.math.Division;
import dk.sdu.mmmi.mdsd.math.GlobalVariable;
import dk.sdu.mmmi.mdsd.math.LocalVariable;
import dk.sdu.mmmi.mdsd.math.MathPackage;
import dk.sdu.mmmi.mdsd.math.Minus;
import dk.sdu.mmmi.mdsd.math.Model;
import dk.sdu.mmmi.mdsd.math.Multiplication;
import dk.sdu.mmmi.mdsd.math.Parenthesis;
import dk.sdu.mmmi.mdsd.math.Plus;
import dk.sdu.mmmi.mdsd.math.VariableReference;
import dk.sdu.mmmi.mdsd.services.MathGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MathSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MathGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MathPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MathPackage.DIVISION:
				sequence_MultiplicationAndDivisionExpression(context, (Division) semanticObject); 
				return; 
			case MathPackage.GLOBAL_VARIABLE:
				sequence_GlobalVariable(context, (GlobalVariable) semanticObject); 
				return; 
			case MathPackage.LOCAL_VARIABLE:
				sequence_LocalVariable(context, (LocalVariable) semanticObject); 
				return; 
			case MathPackage.MINUS:
				sequence_AdditionAndSubtractionExpression(context, (Minus) semanticObject); 
				return; 
			case MathPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case MathPackage.MULTIPLICATION:
				sequence_MultiplicationAndDivisionExpression(context, (Multiplication) semanticObject); 
				return; 
			case MathPackage.NUMBER:
				sequence_ValueExpression(context, (dk.sdu.mmmi.mdsd.math.Number) semanticObject); 
				return; 
			case MathPackage.PARENTHESIS:
				sequence_ValueExpression(context, (Parenthesis) semanticObject); 
				return; 
			case MathPackage.PLUS:
				sequence_AdditionAndSubtractionExpression(context, (Plus) semanticObject); 
				return; 
			case MathPackage.VARIABLE_REFERENCE:
				sequence_VariableReference(context, (VariableReference) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Minus
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Minus
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Minus
	 *
	 * Constraint:
	 *     (left=AdditionAndSubtractionExpression_Minus_1_0_1_0 right=MultiplicationAndDivisionExpression)
	 * </pre>
	 */
	protected void sequence_AdditionAndSubtractionExpression(ISerializationContext context, Minus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAndSubtractionExpressionAccess().getMinusLeftAction_1_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAndSubtractionExpressionAccess().getRightMultiplicationAndDivisionExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Plus
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Plus
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Plus
	 *
	 * Constraint:
	 *     (left=AdditionAndSubtractionExpression_Plus_1_0_0_0 right=MultiplicationAndDivisionExpression)
	 * </pre>
	 */
	protected void sequence_AdditionAndSubtractionExpression(ISerializationContext context, Plus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAndSubtractionExpressionAccess().getPlusLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAndSubtractionExpressionAccess().getRightMultiplicationAndDivisionExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GlobalVariable returns GlobalVariable
	 *
	 * Constraint:
	 *     (name=ID expression=AdditionAndSubtractionExpression)
	 * </pre>
	 */
	protected void sequence_GlobalVariable(ISerializationContext context, GlobalVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE__NAME));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGlobalVariableAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getGlobalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_4_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LocalVariable returns LocalVariable
	 *     AdditionAndSubtractionExpression returns LocalVariable
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns LocalVariable
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns LocalVariable
	 *     MultiplicationAndDivisionExpression returns LocalVariable
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns LocalVariable
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns LocalVariable
	 *     ValueExpression returns LocalVariable
	 *
	 * Constraint:
	 *     (name=ID local_expression=AdditionAndSubtractionExpression expression=AdditionAndSubtractionExpression)
	 * </pre>
	 */
	protected void sequence_LocalVariable(ISerializationContext context, LocalVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE__NAME));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.LOCAL_VARIABLE__LOCAL_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.LOCAL_VARIABLE__LOCAL_EXPRESSION));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLocalVariableAccess().getLocal_expressionAdditionAndSubtractionExpressionParserRuleCall_4_0(), semanticObject.getLocal_expression());
		feeder.accept(grammarAccess.getLocalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_6_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (name=ID variables+=GlobalVariable*)
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Division
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Division
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Division
	 *     MultiplicationAndDivisionExpression returns Division
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns Division
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns Division
	 *
	 * Constraint:
	 *     (left=MultiplicationAndDivisionExpression_Division_1_0_1_0 right=ValueExpression)
	 * </pre>
	 */
	protected void sequence_MultiplicationAndDivisionExpression(ISerializationContext context, Division semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIVISION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIVISION__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIVISION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIVISION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getDivisionLeftAction_1_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getRightValueExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Multiplication
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Multiplication
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Multiplication
	 *     MultiplicationAndDivisionExpression returns Multiplication
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns Multiplication
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns Multiplication
	 *
	 * Constraint:
	 *     (left=MultiplicationAndDivisionExpression_Multiplication_1_0_0_0 right=ValueExpression)
	 * </pre>
	 */
	protected void sequence_MultiplicationAndDivisionExpression(ISerializationContext context, Multiplication semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULTIPLICATION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULTIPLICATION__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULTIPLICATION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULTIPLICATION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getMultiplicationLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getRightValueExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Number
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Number
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Number
	 *     MultiplicationAndDivisionExpression returns Number
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns Number
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns Number
	 *     ValueExpression returns Number
	 *
	 * Constraint:
	 *     value=INT
	 * </pre>
	 */
	protected void sequence_ValueExpression(ISerializationContext context, dk.sdu.mmmi.mdsd.math.Number semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.NUMBER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.NUMBER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getValueExpressionAccess().getValueINTTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns Parenthesis
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns Parenthesis
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns Parenthesis
	 *     MultiplicationAndDivisionExpression returns Parenthesis
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns Parenthesis
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns Parenthesis
	 *     ValueExpression returns Parenthesis
	 *
	 * Constraint:
	 *     parenthesizedExpression=AdditionAndSubtractionExpression
	 * </pre>
	 */
	protected void sequence_ValueExpression(ISerializationContext context, Parenthesis semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PARENTHESIS__PARENTHESIZED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PARENTHESIS__PARENTHESIZED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getValueExpressionAccess().getParenthesizedExpressionAdditionAndSubtractionExpressionParserRuleCall_0_2_0(), semanticObject.getParenthesizedExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AdditionAndSubtractionExpression returns VariableReference
	 *     AdditionAndSubtractionExpression.Plus_1_0_0_0 returns VariableReference
	 *     AdditionAndSubtractionExpression.Minus_1_0_1_0 returns VariableReference
	 *     MultiplicationAndDivisionExpression returns VariableReference
	 *     MultiplicationAndDivisionExpression.Multiplication_1_0_0_0 returns VariableReference
	 *     MultiplicationAndDivisionExpression.Division_1_0_1_0 returns VariableReference
	 *     ValueExpression returns VariableReference
	 *     VariableReference returns VariableReference
	 *
	 * Constraint:
	 *     variable=[Variable|ID]
	 * </pre>
	 */
	protected void sequence_VariableReference(ISerializationContext context, VariableReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE_REFERENCE__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE_REFERENCE__VARIABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableReferenceAccess().getVariableVariableIDTerminalRuleCall_0_1(), semanticObject.eGet(MathPackage.Literals.VARIABLE_REFERENCE__VARIABLE, false));
		feeder.finish();
	}
	
	
}
