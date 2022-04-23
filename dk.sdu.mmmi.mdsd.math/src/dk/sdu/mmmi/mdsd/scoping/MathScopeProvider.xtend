/*
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.scoping

import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes
import dk.sdu.mmmi.mdsd.math.Model
import dk.sdu.mmmi.mdsd.math.GlobalVariable
import dk.sdu.mmmi.mdsd.math.LocalVariable
import dk.sdu.mmmi.mdsd.math.MathPackage.Literals
import dk.sdu.mmmi.mdsd.math.Variable

class MathScopeProvider extends AbstractMathScopeProvider {

	override IScope getScope(EObject context, EReference reference) {
		switch (reference) {
			case Literals.VARIABLE_REFERENCE__VARIABLE: context.getVariableScope(true)
			default: super.getScope(context, reference)
		}
	}

	def IScope getVariableScope(EObject object, boolean first) {
		val nextVariable = first ? EcoreUtil2.getContainerOfType(object, Variable) : EcoreUtil2.getContainerOfType(object.eContainer, Variable);
		if (nextVariable instanceof LocalVariable) {
			return Scopes.scopeFor(#[nextVariable], nextVariable.getVariableScope(false));
		} else {
			return (nextVariable as GlobalVariable).getGlobalVariableScope;
		}
	}

	def IScope getGlobalVariableScope(GlobalVariable globalVariable) {
		val model = EcoreUtil2.getRootContainer(globalVariable) as Model;
		val globalVariables = model.variables.filter[it.name !== globalVariable.name].toList;
		return Scopes.scopeFor(globalVariables)
	}
}