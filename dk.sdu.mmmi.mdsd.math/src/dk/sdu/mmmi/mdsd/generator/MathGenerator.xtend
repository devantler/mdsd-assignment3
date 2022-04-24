package dk.sdu.mmmi.mdsd.generator

import dk.sdu.mmmi.mdsd.math.Division
import dk.sdu.mmmi.mdsd.math.Expression
import dk.sdu.mmmi.mdsd.math.ExternalDefinition
import dk.sdu.mmmi.mdsd.math.GlobalVariable
import dk.sdu.mmmi.mdsd.math.LocalVariable
import dk.sdu.mmmi.mdsd.math.Minus
import dk.sdu.mmmi.mdsd.math.Model
import dk.sdu.mmmi.mdsd.math.Multiplication
import dk.sdu.mmmi.mdsd.math.Number
import dk.sdu.mmmi.mdsd.math.Parenthesis
import dk.sdu.mmmi.mdsd.math.Plus
import dk.sdu.mmmi.mdsd.math.Variable
import dk.sdu.mmmi.mdsd.math.VariableReference
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import dk.sdu.mmmi.mdsd.math.SqrtExternalDefinition
import dk.sdu.mmmi.mdsd.math.PowExternalDefinition
import dk.sdu.mmmi.mdsd.math.External
import dk.sdu.mmmi.mdsd.math.PiExternal
import dk.sdu.mmmi.mdsd.math.SqrtExternal
import dk.sdu.mmmi.mdsd.math.PowExternal

class MathGenerator extends AbstractGenerator {

	static Map<String, String> variables = new HashMap;

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val model = input.allContents.filter(Model).next
		fsa.generateFile("math_expression/" + model.name + ".java", model.compile())
	}

	def static String compile(Model model) '''
		package math_expression;
		
		public class «model.name» {
			
			«FOR globalVariable : model.variables.filter[it instanceof GlobalVariable]»
				public int «globalVariable.name»;

			«ENDFOR»
			«IF !model.externalDefinitions.isNullOrEmpty»
				private External external;
				
				public «model.name»(External external) {
				    this.external = external;
				}
				
				public interface External {
					«FOR externalDefinition:model.externalDefinitions»
						«generateExternalDefinition(externalDefinition)»
					«ENDFOR»
				}

		«ENDIF»
			public void compute() {
			«FOR variable : model.variables»
			«"	"»«variable.name» = «(variable as GlobalVariable).compile»;
			«ENDFOR»
			}
		} 
	'''

	protected def static CharSequence generateExternalDefinition(ExternalDefinition externalDefinition) {
		val parameters = switch externalDefinition {
			SqrtExternalDefinition: externalDefinition.param1 + " n"
			PowExternalDefinition: externalDefinition.param1 + " n1, " + externalDefinition.param2 + " n2"
			default: ""
		}
		'''public int «externalDefinition.name»(«parameters»);'''
	}

	def static String compile(GlobalVariable globalVariable) {
		val expressionValue = globalVariable.expression.compileExp(new HashMap)
		variables.put(globalVariable.name, expressionValue)
		return variables.get(globalVariable.name)
	}

	def static dispatch String compileExp(Expression expression, Map<String, String> localVariables) {
		switch expression {
			Plus:
				expression.left.compileExp(localVariables) + ' + ' + expression.right.compileExp(localVariables)
			Minus:
				expression.left.compileExp(localVariables) + ' - ' + expression.right.compileExp(localVariables)
			Multiplication:
				expression.left.compileExp(localVariables) + ' * ' + expression.right.compileExp(localVariables)
			Division:
				expression.left.compileExp(localVariables) + ' / ' + expression.right.compileExp(localVariables)
			Number:
				expression.value.toString
			Parenthesis:
				'(' + expression.parenthesizedExpression.compileExp(localVariables) + ')'
		}
	}

	def dispatch static String compileExp(External external, Map<String, String> localVariable){
		var result = 'this.external.'
		switch external {
		 	PiExternal: return result + external.name + '()'
		 	SqrtExternal: return result + external.name + '(' + external.param1.compileExp(localVariable) + ')'
			PowExternal: return result + external.name + '(' + external.param1.compileExp(localVariable) + ', ' + external.param2.compileExp(localVariable) + ')'
		}
	}
	
	def dispatch static String compileExp(Variable variable, Map<String, String> localVariables) {
		val nestedVariables = new HashMap(localVariables);
		if (variable instanceof LocalVariable) {
			nestedVariables.put(variable.name, variable.local_expression.compileExp(nestedVariables))
		}
		variable.expression.compileExp(nestedVariables)
	}

	def dispatch static String compileExp(VariableReference reference, Map<String, String> localVariables) {
		val globalVariable = variables.get(reference.variable.name)
		val localVariable = localVariables.get(reference.variable.name)
		switch reference.variable {
			LocalVariable:
				localVariable !== null ? '(' + localVariable + ')' : '(' + globalVariable + ')'
			GlobalVariable:
				globalVariable !== null
					? '(' + globalVariable + ')'
					: '(' + reference.variable.compileExp(localVariables) + ')'
		}
	}
}
