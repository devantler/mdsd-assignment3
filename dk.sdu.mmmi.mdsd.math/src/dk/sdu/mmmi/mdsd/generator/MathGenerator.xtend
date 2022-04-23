package dk.sdu.mmmi.mdsd.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import dk.sdu.mmmi.mdsd.math.Model
import dk.sdu.mmmi.mdsd.math.Expression
import dk.sdu.mmmi.mdsd.math.Plus
import dk.sdu.mmmi.mdsd.math.Minus
import dk.sdu.mmmi.mdsd.math.Multiplication
import dk.sdu.mmmi.mdsd.math.Division
import dk.sdu.mmmi.mdsd.math.Parenthesis
import java.util.Map
import java.util.HashMap

class MathGenerator extends AbstractGenerator {

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val model = input.allContents.filter(Model).next
		fsa.generateFile(model.name+".java", model.compile)
	}

	def static dispatch String compile(Model model)'''
		package math_expression;
		
		public class MathComputation {
			
			public int x;
			
			private External external;
			
			public void compute() {
				{
					int i;
				}
				«FOR variable:model.variables»
				«variable.name» = «variable.expression.compileExp(new HashMap())»
				«ENDFOR»
			}
			
			interface External {
				public int sqrt(int n);
			}
		}
		
	'''
	
	def static dispatch String compileExp(Expression expression, Map<String, Integer> localVariables) {
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
				expression.value
			Parenthesis:
				expression.parenthesizedExpression.compileExp(localVariables)
		}
	}
}
