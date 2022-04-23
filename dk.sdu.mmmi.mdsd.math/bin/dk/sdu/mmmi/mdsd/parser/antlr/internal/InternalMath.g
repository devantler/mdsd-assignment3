/*
 * generated by Xtext 2.26.0
 */
grammar InternalMath;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package dk.sdu.mmmi.mdsd.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package dk.sdu.mmmi.mdsd.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import dk.sdu.mmmi.mdsd.services.MathGrammarAccess;

}

@parser::members {

 	private MathGrammarAccess grammarAccess;

    public InternalMathParser(TokenStream input, MathGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected MathGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='program'
		{
			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getProgramKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getVariablesGlobalVariableParserRuleCall_2_0());
				}
				lv_variables_2_0=ruleGlobalVariable
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"variables",
						lv_variables_2_0,
						"dk.sdu.mmmi.mdsd.Math.GlobalVariable");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleGlobalVariable
entryRuleGlobalVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGlobalVariableRule()); }
	iv_ruleGlobalVariable=ruleGlobalVariable
	{ $current=$iv_ruleGlobalVariable.current; }
	EOF;

// Rule GlobalVariable
ruleGlobalVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getGlobalVariableAccess().getGlobalVariableAction_0(),
					$current);
			}
		)
		otherlv_1='var'
		{
			newLeafNode(otherlv_1, grammarAccess.getGlobalVariableAccess().getVarKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getGlobalVariableAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGlobalVariableRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getGlobalVariableAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGlobalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_4_0());
				}
				lv_expression_4_0=ruleAdditionAndSubtractionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGlobalVariableRule());
					}
					set(
						$current,
						"expression",
						lv_expression_4_0,
						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLocalVariable
entryRuleLocalVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLocalVariableRule()); }
	iv_ruleLocalVariable=ruleLocalVariable
	{ $current=$iv_ruleLocalVariable.current; }
	EOF;

// Rule LocalVariable
ruleLocalVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLocalVariableAccess().getLocalVariableAction_0(),
					$current);
			}
		)
		otherlv_1='let'
		{
			newLeafNode(otherlv_1, grammarAccess.getLocalVariableAccess().getLetKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLocalVariableRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getLocalVariableAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLocalVariableAccess().getLocal_expressionAdditionAndSubtractionExpressionParserRuleCall_4_0());
				}
				lv_local_expression_4_0=ruleAdditionAndSubtractionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLocalVariableRule());
					}
					set(
						$current,
						"local_expression",
						lv_local_expression_4_0,
						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='in'
		{
			newLeafNode(otherlv_5, grammarAccess.getLocalVariableAccess().getInKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLocalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_6_0());
				}
				lv_expression_6_0=ruleAdditionAndSubtractionExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLocalVariableRule());
					}
					set(
						$current,
						"expression",
						lv_expression_6_0,
						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='end'
		{
			newLeafNode(otherlv_7, grammarAccess.getLocalVariableAccess().getEndKeyword_7());
		}
	)
;

// Entry rule entryRuleAdditionAndSubtractionExpression
entryRuleAdditionAndSubtractionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionRule()); }
	iv_ruleAdditionAndSubtractionExpression=ruleAdditionAndSubtractionExpression
	{ $current=$iv_ruleAdditionAndSubtractionExpression.current; }
	EOF;

// Rule AdditionAndSubtractionExpression
ruleAdditionAndSubtractionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionAccess().getMultiplicationAndDivisionExpressionParserRuleCall_0());
		}
		this_MultiplicationAndDivisionExpression_0=ruleMultiplicationAndDivisionExpression
		{
			$current = $this_MultiplicationAndDivisionExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAdditionAndSubtractionExpressionAccess().getPlusLeftAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2='+'
					{
						newLeafNode(otherlv_2, grammarAccess.getAdditionAndSubtractionExpressionAccess().getPlusSignKeyword_1_0_0_1());
					}
				)
				    |
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAdditionAndSubtractionExpressionAccess().getMinusLeftAction_1_0_1_0(),
								$current);
						}
					)
					otherlv_4='-'
					{
						newLeafNode(otherlv_4, grammarAccess.getAdditionAndSubtractionExpressionAccess().getHyphenMinusKeyword_1_0_1_1());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionAccess().getRightMultiplicationAndDivisionExpressionParserRuleCall_1_1_0());
					}
					lv_right_5_0=ruleMultiplicationAndDivisionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAdditionAndSubtractionExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_5_0,
							"dk.sdu.mmmi.mdsd.Math.MultiplicationAndDivisionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleMultiplicationAndDivisionExpression
entryRuleMultiplicationAndDivisionExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionRule()); }
	iv_ruleMultiplicationAndDivisionExpression=ruleMultiplicationAndDivisionExpression
	{ $current=$iv_ruleMultiplicationAndDivisionExpression.current; }
	EOF;

// Rule MultiplicationAndDivisionExpression
ruleMultiplicationAndDivisionExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getValueExpressionParserRuleCall_0());
		}
		this_ValueExpression_0=ruleValueExpression
		{
			$current = $this_ValueExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getMultiplicationAndDivisionExpressionAccess().getMultiplicationLeftAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2='*'
					{
						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAndDivisionExpressionAccess().getAsteriskKeyword_1_0_0_1());
					}
				)
				    |
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getMultiplicationAndDivisionExpressionAccess().getDivisionLeftAction_1_0_1_0(),
								$current);
						}
					)
					otherlv_4='/'
					{
						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAndDivisionExpressionAccess().getSolidusKeyword_1_0_1_1());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getRightValueExpressionParserRuleCall_1_1_0());
					}
					lv_right_5_0=ruleValueExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMultiplicationAndDivisionExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_5_0,
							"dk.sdu.mmmi.mdsd.Math.ValueExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleValueExpression
entryRuleValueExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValueExpressionRule()); }
	iv_ruleValueExpression=ruleValueExpression
	{ $current=$iv_ruleValueExpression.current; }
	EOF;

// Rule ValueExpression
ruleValueExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getValueExpressionAccess().getParenthesisAction_0_0(),
						$current);
				}
			)
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getValueExpressionAccess().getLeftParenthesisKeyword_0_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getValueExpressionAccess().getParenthesizedExpressionAdditionAndSubtractionExpressionParserRuleCall_0_2_0());
					}
					lv_parenthesizedExpression_2_0=ruleAdditionAndSubtractionExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getValueExpressionRule());
						}
						set(
							$current,
							"parenthesizedExpression",
							lv_parenthesizedExpression_2_0,
							"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getValueExpressionAccess().getRightParenthesisKeyword_0_3());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getValueExpressionAccess().getNumberAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_value_5_0=RULE_INT
					{
						newLeafNode(lv_value_5_0, grammarAccess.getValueExpressionAccess().getValueINTTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValueExpressionRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_5_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getValueExpressionAccess().getLocalVariableParserRuleCall_2());
		}
		this_LocalVariable_6=ruleLocalVariable
		{
			$current = $this_LocalVariable_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getValueExpressionAccess().getVariableReferenceParserRuleCall_3());
		}
		this_VariableReference_7=ruleVariableReference
		{
			$current = $this_VariableReference_7.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleVariableReference
entryRuleVariableReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableReferenceRule()); }
	iv_ruleVariableReference=ruleVariableReference
	{ $current=$iv_ruleVariableReference.current; }
	EOF;

// Rule VariableReference
ruleVariableReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getVariableReferenceRule());
				}
			}
			otherlv_0=RULE_ID
			{
				newLeafNode(otherlv_0, grammarAccess.getVariableReferenceAccess().getVariableVariableCrossReference_0());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;