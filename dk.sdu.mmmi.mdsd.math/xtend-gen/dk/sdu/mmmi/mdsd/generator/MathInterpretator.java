/**
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator;

import com.google.common.collect.Iterators;
import dk.sdu.mmmi.mdsd.math.Division;
import dk.sdu.mmmi.mdsd.math.Expression;
import dk.sdu.mmmi.mdsd.math.GlobalVariable;
import dk.sdu.mmmi.mdsd.math.LocalVariable;
import dk.sdu.mmmi.mdsd.math.Minus;
import dk.sdu.mmmi.mdsd.math.Model;
import dk.sdu.mmmi.mdsd.math.Multiplication;
import dk.sdu.mmmi.mdsd.math.Parenthesis;
import dk.sdu.mmmi.mdsd.math.Plus;
import dk.sdu.mmmi.mdsd.math.Variable;
import dk.sdu.mmmi.mdsd.math.VariableReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MathInterpretator extends AbstractGenerator {
  private static Map<String, Integer> variables;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Model model = Iterators.<Model>filter(resource.getAllContents(), Model.class).next();
    final Map<String, Integer> result = MathInterpretator.compute(model);
    this.displayPanel(result);
  }
  
  public static Map<String, Integer> compute(final Model model) {
    HashMap<String, Integer> _hashMap = new HashMap<String, Integer>();
    MathInterpretator.variables = _hashMap;
    EList<Variable> _variables = model.getVariables();
    for (final Variable variable : _variables) {
      Expression _expression = variable.getExpression();
      HashMap<String, Integer> _hashMap_1 = new HashMap<String, Integer>();
      MathInterpretator.variables.put(variable.getName(), Integer.valueOf(MathInterpretator.computeExp(_expression, _hashMap_1)));
    }
    return MathInterpretator.variables;
  }
  
  protected static int _computeExp(final Expression expression, final Map<String, Integer> localVariables) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (expression instanceof Plus) {
      _matched=true;
      int _computeExp = MathInterpretator.computeExp(((Plus)expression).getLeft(), localVariables);
      int _computeExp_1 = MathInterpretator.computeExp(((Plus)expression).getRight(), localVariables);
      _switchResult = (_computeExp + _computeExp_1);
    }
    if (!_matched) {
      if (expression instanceof Minus) {
        _matched=true;
        int _computeExp = MathInterpretator.computeExp(((Minus)expression).getLeft(), localVariables);
        int _computeExp_1 = MathInterpretator.computeExp(((Minus)expression).getRight(), localVariables);
        _switchResult = (_computeExp - _computeExp_1);
      }
    }
    if (!_matched) {
      if (expression instanceof Multiplication) {
        _matched=true;
        int _computeExp = MathInterpretator.computeExp(((Multiplication)expression).getLeft(), localVariables);
        int _computeExp_1 = MathInterpretator.computeExp(((Multiplication)expression).getRight(), localVariables);
        _switchResult = (_computeExp * _computeExp_1);
      }
    }
    if (!_matched) {
      if (expression instanceof Division) {
        _matched=true;
        int _computeExp = MathInterpretator.computeExp(((Division)expression).getLeft(), localVariables);
        int _computeExp_1 = MathInterpretator.computeExp(((Division)expression).getRight(), localVariables);
        _switchResult = (_computeExp / _computeExp_1);
      }
    }
    if (!_matched) {
      if (expression instanceof dk.sdu.mmmi.mdsd.math.Number) {
        _matched=true;
        _switchResult = ((dk.sdu.mmmi.mdsd.math.Number)expression).getValue();
      }
    }
    if (!_matched) {
      if (expression instanceof Parenthesis) {
        _matched=true;
        _switchResult = MathInterpretator.computeExp(((Parenthesis)expression).getParenthesizedExpression(), localVariables);
      }
    }
    return _switchResult;
  }
  
  protected static int _computeExp(final Variable variable, final Map<String, Integer> localVariables) {
    int _xblockexpression = (int) 0;
    {
      final HashMap<String, Integer> nestedVariables = new HashMap<String, Integer>(localVariables);
      if ((variable instanceof LocalVariable)) {
        nestedVariables.put(((LocalVariable)variable).getName(), Integer.valueOf(MathInterpretator.computeExp(((LocalVariable)variable).getLocal_expression(), nestedVariables)));
      }
      _xblockexpression = MathInterpretator.computeExp(variable.getExpression(), nestedVariables);
    }
    return _xblockexpression;
  }
  
  protected static int _computeExp(final VariableReference reference, final Map<String, Integer> localVariables) {
    Integer _xblockexpression = null;
    {
      final Integer globalVariable = MathInterpretator.variables.get(reference.getVariable().getName());
      final Integer localVariable = localVariables.get(reference.getVariable().getName());
      Integer _switchResult = null;
      Variable _variable = reference.getVariable();
      boolean _matched = false;
      if (_variable instanceof LocalVariable) {
        _matched=true;
        Integer _xifexpression = null;
        if ((localVariable != null)) {
          _xifexpression = localVariable;
        } else {
          _xifexpression = globalVariable;
        }
        _switchResult = _xifexpression;
      }
      if (!_matched) {
        if (_variable instanceof GlobalVariable) {
          _matched=true;
          Integer _xifexpression = null;
          if ((globalVariable != null)) {
            _xifexpression = globalVariable;
          } else {
            _xifexpression = Integer.valueOf(MathInterpretator.computeExp(reference.getVariable(), localVariables));
          }
          _switchResult = _xifexpression;
        }
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).intValue();
  }
  
  public void displayPanel(final Map<String, Integer> result) {
    String resultString = "";
    Set<Map.Entry<String, Integer>> _entrySet = result.entrySet();
    for (final Map.Entry<String, Integer> entry : _entrySet) {
      String _resultString = resultString;
      String _key = entry.getKey();
      String _plus = ("var " + _key);
      String _plus_1 = (_plus + " = ");
      Integer _value = entry.getValue();
      String _plus_2 = (_plus_1 + _value);
      String _plus_3 = (_plus_2 + "\n");
      resultString = (_resultString + _plus_3);
    }
    JOptionPane.showMessageDialog(null, resultString, "Math Language", JOptionPane.INFORMATION_MESSAGE);
  }
  
  public static int computeExp(final Expression variable, final Map<String, Integer> localVariables) {
    if (variable instanceof Variable) {
      return _computeExp((Variable)variable, localVariables);
    } else if (variable instanceof VariableReference) {
      return _computeExp((VariableReference)variable, localVariables);
    } else if (variable != null) {
      return _computeExp(variable, localVariables);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(variable, localVariables).toString());
    }
  }
}