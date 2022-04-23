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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMathParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'var'", "'='", "'let'", "'in'", "'end'", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMathParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMath.g"; }



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




    // $ANTLR start "entryRuleModel"
    // InternalMath.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMath.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMath.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMath.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) ( (lv_variables_2_0= ruleGlobalVariable ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_variables_2_0 = null;



        	enterRule();

        try {
            // InternalMath.g:77:2: ( (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) ( (lv_variables_2_0= ruleGlobalVariable ) )* ) )
            // InternalMath.g:78:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) ( (lv_variables_2_0= ruleGlobalVariable ) )* )
            {
            // InternalMath.g:78:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) ( (lv_variables_2_0= ruleGlobalVariable ) )* )
            // InternalMath.g:79:3: otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) ( (lv_variables_2_0= ruleGlobalVariable ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getProgramKeyword_0());
            		
            // InternalMath.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMath.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMath.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalMath.g:85:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMath.g:101:3: ( (lv_variables_2_0= ruleGlobalVariable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMath.g:102:4: (lv_variables_2_0= ruleGlobalVariable )
            	    {
            	    // InternalMath.g:102:4: (lv_variables_2_0= ruleGlobalVariable )
            	    // InternalMath.g:103:5: lv_variables_2_0= ruleGlobalVariable
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getVariablesGlobalVariableParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_variables_2_0=ruleGlobalVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_2_0,
            	    						"dk.sdu.mmmi.mdsd.Math.GlobalVariable");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGlobalVariable"
    // InternalMath.g:124:1: entryRuleGlobalVariable returns [EObject current=null] : iv_ruleGlobalVariable= ruleGlobalVariable EOF ;
    public final EObject entryRuleGlobalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariable = null;


        try {
            // InternalMath.g:124:55: (iv_ruleGlobalVariable= ruleGlobalVariable EOF )
            // InternalMath.g:125:2: iv_ruleGlobalVariable= ruleGlobalVariable EOF
            {
             newCompositeNode(grammarAccess.getGlobalVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVariable=ruleGlobalVariable();

            state._fsp--;

             current =iv_ruleGlobalVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalVariable"


    // $ANTLR start "ruleGlobalVariable"
    // InternalMath.g:131:1: ruleGlobalVariable returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) ) ) ;
    public final EObject ruleGlobalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalMath.g:137:2: ( ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) ) ) )
            // InternalMath.g:138:2: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) ) )
            {
            // InternalMath.g:138:2: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) ) )
            // InternalMath.g:139:3: () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) )
            {
            // InternalMath.g:139:3: ()
            // InternalMath.g:140:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalVariableAccess().getGlobalVariableAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVariableAccess().getVarKeyword_1());
            		
            // InternalMath.g:150:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMath.g:151:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMath.g:151:4: (lv_name_2_0= RULE_ID )
            // InternalMath.g:152:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getGlobalVariableAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGlobalVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getGlobalVariableAccess().getEqualsSignKeyword_3());
            		
            // InternalMath.g:172:3: ( (lv_expression_4_0= ruleAdditionAndSubtractionExpression ) )
            // InternalMath.g:173:4: (lv_expression_4_0= ruleAdditionAndSubtractionExpression )
            {
            // InternalMath.g:173:4: (lv_expression_4_0= ruleAdditionAndSubtractionExpression )
            // InternalMath.g:174:5: lv_expression_4_0= ruleAdditionAndSubtractionExpression
            {

            					newCompositeNode(grammarAccess.getGlobalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleAdditionAndSubtractionExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGlobalVariableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_4_0,
            						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalVariable"


    // $ANTLR start "entryRuleLocalVariable"
    // InternalMath.g:195:1: entryRuleLocalVariable returns [EObject current=null] : iv_ruleLocalVariable= ruleLocalVariable EOF ;
    public final EObject entryRuleLocalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalVariable = null;


        try {
            // InternalMath.g:195:54: (iv_ruleLocalVariable= ruleLocalVariable EOF )
            // InternalMath.g:196:2: iv_ruleLocalVariable= ruleLocalVariable EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalVariable=ruleLocalVariable();

            state._fsp--;

             current =iv_ruleLocalVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalVariable"


    // $ANTLR start "ruleLocalVariable"
    // InternalMath.g:202:1: ruleLocalVariable returns [EObject current=null] : ( () otherlv_1= 'let' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) ) otherlv_5= 'in' ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) ) otherlv_7= 'end' ) ;
    public final EObject ruleLocalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_local_expression_4_0 = null;

        EObject lv_expression_6_0 = null;



        	enterRule();

        try {
            // InternalMath.g:208:2: ( ( () otherlv_1= 'let' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) ) otherlv_5= 'in' ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) ) otherlv_7= 'end' ) )
            // InternalMath.g:209:2: ( () otherlv_1= 'let' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) ) otherlv_5= 'in' ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) ) otherlv_7= 'end' )
            {
            // InternalMath.g:209:2: ( () otherlv_1= 'let' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) ) otherlv_5= 'in' ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) ) otherlv_7= 'end' )
            // InternalMath.g:210:3: () otherlv_1= 'let' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) ) otherlv_5= 'in' ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) ) otherlv_7= 'end'
            {
            // InternalMath.g:210:3: ()
            // InternalMath.g:211:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLocalVariableAccess().getLocalVariableAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalVariableAccess().getLetKeyword_1());
            		
            // InternalMath.g:221:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMath.g:222:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMath.g:222:4: (lv_name_2_0= RULE_ID )
            // InternalMath.g:223:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalVariableAccess().getEqualsSignKeyword_3());
            		
            // InternalMath.g:243:3: ( (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression ) )
            // InternalMath.g:244:4: (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression )
            {
            // InternalMath.g:244:4: (lv_local_expression_4_0= ruleAdditionAndSubtractionExpression )
            // InternalMath.g:245:5: lv_local_expression_4_0= ruleAdditionAndSubtractionExpression
            {

            					newCompositeNode(grammarAccess.getLocalVariableAccess().getLocal_expressionAdditionAndSubtractionExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_local_expression_4_0=ruleAdditionAndSubtractionExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalVariableRule());
            					}
            					set(
            						current,
            						"local_expression",
            						lv_local_expression_4_0,
            						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getLocalVariableAccess().getInKeyword_5());
            		
            // InternalMath.g:266:3: ( (lv_expression_6_0= ruleAdditionAndSubtractionExpression ) )
            // InternalMath.g:267:4: (lv_expression_6_0= ruleAdditionAndSubtractionExpression )
            {
            // InternalMath.g:267:4: (lv_expression_6_0= ruleAdditionAndSubtractionExpression )
            // InternalMath.g:268:5: lv_expression_6_0= ruleAdditionAndSubtractionExpression
            {

            					newCompositeNode(grammarAccess.getLocalVariableAccess().getExpressionAdditionAndSubtractionExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_6_0=ruleAdditionAndSubtractionExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalVariableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_6_0,
            						"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLocalVariableAccess().getEndKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalVariable"


    // $ANTLR start "entryRuleAdditionAndSubtractionExpression"
    // InternalMath.g:293:1: entryRuleAdditionAndSubtractionExpression returns [EObject current=null] : iv_ruleAdditionAndSubtractionExpression= ruleAdditionAndSubtractionExpression EOF ;
    public final EObject entryRuleAdditionAndSubtractionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionAndSubtractionExpression = null;


        try {
            // InternalMath.g:293:73: (iv_ruleAdditionAndSubtractionExpression= ruleAdditionAndSubtractionExpression EOF )
            // InternalMath.g:294:2: iv_ruleAdditionAndSubtractionExpression= ruleAdditionAndSubtractionExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditionAndSubtractionExpression=ruleAdditionAndSubtractionExpression();

            state._fsp--;

             current =iv_ruleAdditionAndSubtractionExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditionAndSubtractionExpression"


    // $ANTLR start "ruleAdditionAndSubtractionExpression"
    // InternalMath.g:300:1: ruleAdditionAndSubtractionExpression returns [EObject current=null] : (this_MultiplicationAndDivisionExpression_0= ruleMultiplicationAndDivisionExpression ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )* ) ;
    public final EObject ruleAdditionAndSubtractionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MultiplicationAndDivisionExpression_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMath.g:306:2: ( (this_MultiplicationAndDivisionExpression_0= ruleMultiplicationAndDivisionExpression ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )* ) )
            // InternalMath.g:307:2: (this_MultiplicationAndDivisionExpression_0= ruleMultiplicationAndDivisionExpression ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )* )
            {
            // InternalMath.g:307:2: (this_MultiplicationAndDivisionExpression_0= ruleMultiplicationAndDivisionExpression ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )* )
            // InternalMath.g:308:3: this_MultiplicationAndDivisionExpression_0= ruleMultiplicationAndDivisionExpression ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionAccess().getMultiplicationAndDivisionExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_9);
            this_MultiplicationAndDivisionExpression_0=ruleMultiplicationAndDivisionExpression();

            state._fsp--;


            			current = this_MultiplicationAndDivisionExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMath.g:316:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=17 && LA3_0<=18)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMath.g:317:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) )
            	    {
            	    // InternalMath.g:317:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==17) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==18) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalMath.g:318:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalMath.g:318:5: ( () otherlv_2= '+' )
            	            // InternalMath.g:319:6: () otherlv_2= '+'
            	            {
            	            // InternalMath.g:319:6: ()
            	            // InternalMath.g:320:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAndSubtractionExpressionAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,17,FOLLOW_6); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAndSubtractionExpressionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMath.g:332:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalMath.g:332:5: ( () otherlv_4= '-' )
            	            // InternalMath.g:333:6: () otherlv_4= '-'
            	            {
            	            // InternalMath.g:333:6: ()
            	            // InternalMath.g:334:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAndSubtractionExpressionAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,18,FOLLOW_6); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAndSubtractionExpressionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMath.g:346:4: ( (lv_right_5_0= ruleMultiplicationAndDivisionExpression ) )
            	    // InternalMath.g:347:5: (lv_right_5_0= ruleMultiplicationAndDivisionExpression )
            	    {
            	    // InternalMath.g:347:5: (lv_right_5_0= ruleMultiplicationAndDivisionExpression )
            	    // InternalMath.g:348:6: lv_right_5_0= ruleMultiplicationAndDivisionExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAndSubtractionExpressionAccess().getRightMultiplicationAndDivisionExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_right_5_0=ruleMultiplicationAndDivisionExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionAndSubtractionExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"dk.sdu.mmmi.mdsd.Math.MultiplicationAndDivisionExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditionAndSubtractionExpression"


    // $ANTLR start "entryRuleMultiplicationAndDivisionExpression"
    // InternalMath.g:370:1: entryRuleMultiplicationAndDivisionExpression returns [EObject current=null] : iv_ruleMultiplicationAndDivisionExpression= ruleMultiplicationAndDivisionExpression EOF ;
    public final EObject entryRuleMultiplicationAndDivisionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationAndDivisionExpression = null;


        try {
            // InternalMath.g:370:76: (iv_ruleMultiplicationAndDivisionExpression= ruleMultiplicationAndDivisionExpression EOF )
            // InternalMath.g:371:2: iv_ruleMultiplicationAndDivisionExpression= ruleMultiplicationAndDivisionExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicationAndDivisionExpression=ruleMultiplicationAndDivisionExpression();

            state._fsp--;

             current =iv_ruleMultiplicationAndDivisionExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicationAndDivisionExpression"


    // $ANTLR start "ruleMultiplicationAndDivisionExpression"
    // InternalMath.g:377:1: ruleMultiplicationAndDivisionExpression returns [EObject current=null] : (this_ValueExpression_0= ruleValueExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )* ) ;
    public final EObject ruleMultiplicationAndDivisionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ValueExpression_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMath.g:383:2: ( (this_ValueExpression_0= ruleValueExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )* ) )
            // InternalMath.g:384:2: (this_ValueExpression_0= ruleValueExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )* )
            {
            // InternalMath.g:384:2: (this_ValueExpression_0= ruleValueExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )* )
            // InternalMath.g:385:3: this_ValueExpression_0= ruleValueExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getValueExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_10);
            this_ValueExpression_0=ruleValueExpression();

            state._fsp--;


            			current = this_ValueExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMath.g:393:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=19 && LA5_0<=20)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMath.g:394:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleValueExpression ) )
            	    {
            	    // InternalMath.g:394:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==19) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==20) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalMath.g:395:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalMath.g:395:5: ( () otherlv_2= '*' )
            	            // InternalMath.g:396:6: () otherlv_2= '*'
            	            {
            	            // InternalMath.g:396:6: ()
            	            // InternalMath.g:397:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAndDivisionExpressionAccess().getMultiplicationLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAndDivisionExpressionAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMath.g:409:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalMath.g:409:5: ( () otherlv_4= '/' )
            	            // InternalMath.g:410:6: () otherlv_4= '/'
            	            {
            	            // InternalMath.g:410:6: ()
            	            // InternalMath.g:411:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAndDivisionExpressionAccess().getDivisionLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,20,FOLLOW_6); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAndDivisionExpressionAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMath.g:423:4: ( (lv_right_5_0= ruleValueExpression ) )
            	    // InternalMath.g:424:5: (lv_right_5_0= ruleValueExpression )
            	    {
            	    // InternalMath.g:424:5: (lv_right_5_0= ruleValueExpression )
            	    // InternalMath.g:425:6: lv_right_5_0= ruleValueExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAndDivisionExpressionAccess().getRightValueExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_right_5_0=ruleValueExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationAndDivisionExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"dk.sdu.mmmi.mdsd.Math.ValueExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicationAndDivisionExpression"


    // $ANTLR start "entryRuleValueExpression"
    // InternalMath.g:447:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // InternalMath.g:447:56: (iv_ruleValueExpression= ruleValueExpression EOF )
            // InternalMath.g:448:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
             newCompositeNode(grammarAccess.getValueExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueExpression=ruleValueExpression();

            state._fsp--;

             current =iv_ruleValueExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueExpression"


    // $ANTLR start "ruleValueExpression"
    // InternalMath.g:454:1: ruleValueExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | this_LocalVariable_6= ruleLocalVariable | this_VariableReference_7= ruleVariableReference ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_value_5_0=null;
        EObject lv_parenthesizedExpression_2_0 = null;

        EObject this_LocalVariable_6 = null;

        EObject this_VariableReference_7 = null;



        	enterRule();

        try {
            // InternalMath.g:460:2: ( ( ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | this_LocalVariable_6= ruleLocalVariable | this_VariableReference_7= ruleVariableReference ) )
            // InternalMath.g:461:2: ( ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | this_LocalVariable_6= ruleLocalVariable | this_VariableReference_7= ruleVariableReference )
            {
            // InternalMath.g:461:2: ( ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' ) | ( () ( (lv_value_5_0= RULE_INT ) ) ) | this_LocalVariable_6= ruleLocalVariable | this_VariableReference_7= ruleVariableReference )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case RULE_ID:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMath.g:462:3: ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' )
                    {
                    // InternalMath.g:462:3: ( () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')' )
                    // InternalMath.g:463:4: () otherlv_1= '(' ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) ) otherlv_3= ')'
                    {
                    // InternalMath.g:463:4: ()
                    // InternalMath.g:464:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getValueExpressionAccess().getParenthesisAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getValueExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalMath.g:474:4: ( (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression ) )
                    // InternalMath.g:475:5: (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression )
                    {
                    // InternalMath.g:475:5: (lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression )
                    // InternalMath.g:476:6: lv_parenthesizedExpression_2_0= ruleAdditionAndSubtractionExpression
                    {

                    						newCompositeNode(grammarAccess.getValueExpressionAccess().getParenthesizedExpressionAdditionAndSubtractionExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parenthesizedExpression_2_0=ruleAdditionAndSubtractionExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getValueExpressionRule());
                    						}
                    						set(
                    							current,
                    							"parenthesizedExpression",
                    							lv_parenthesizedExpression_2_0,
                    							"dk.sdu.mmmi.mdsd.Math.AdditionAndSubtractionExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getValueExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMath.g:499:3: ( () ( (lv_value_5_0= RULE_INT ) ) )
                    {
                    // InternalMath.g:499:3: ( () ( (lv_value_5_0= RULE_INT ) ) )
                    // InternalMath.g:500:4: () ( (lv_value_5_0= RULE_INT ) )
                    {
                    // InternalMath.g:500:4: ()
                    // InternalMath.g:501:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getValueExpressionAccess().getNumberAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMath.g:507:4: ( (lv_value_5_0= RULE_INT ) )
                    // InternalMath.g:508:5: (lv_value_5_0= RULE_INT )
                    {
                    // InternalMath.g:508:5: (lv_value_5_0= RULE_INT )
                    // InternalMath.g:509:6: lv_value_5_0= RULE_INT
                    {
                    lv_value_5_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_5_0, grammarAccess.getValueExpressionAccess().getValueINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMath.g:527:3: this_LocalVariable_6= ruleLocalVariable
                    {

                    			newCompositeNode(grammarAccess.getValueExpressionAccess().getLocalVariableParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LocalVariable_6=ruleLocalVariable();

                    state._fsp--;


                    			current = this_LocalVariable_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMath.g:536:3: this_VariableReference_7= ruleVariableReference
                    {

                    			newCompositeNode(grammarAccess.getValueExpressionAccess().getVariableReferenceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableReference_7=ruleVariableReference();

                    state._fsp--;


                    			current = this_VariableReference_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueExpression"


    // $ANTLR start "entryRuleVariableReference"
    // InternalMath.g:548:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // InternalMath.g:548:58: (iv_ruleVariableReference= ruleVariableReference EOF )
            // InternalMath.g:549:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
             newCompositeNode(grammarAccess.getVariableReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableReference=ruleVariableReference();

            state._fsp--;

             current =iv_ruleVariableReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableReference"


    // $ANTLR start "ruleVariableReference"
    // InternalMath.g:555:1: ruleVariableReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMath.g:561:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalMath.g:562:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalMath.g:562:2: ( (otherlv_0= RULE_ID ) )
            // InternalMath.g:563:3: (otherlv_0= RULE_ID )
            {
            // InternalMath.g:563:3: (otherlv_0= RULE_ID )
            // InternalMath.g:564:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVariableReferenceAccess().getVariableVariableCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableReference"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000204030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});

}