package dk.sdu.mmmi.mdsd.generator;

import com.google.common.collect.Iterators;
import dk.sdu.mmmi.mdsd.math.Expression;
import dk.sdu.mmmi.mdsd.math.Model;
import dk.sdu.mmmi.mdsd.math.Variable;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

@SuppressWarnings("all")
public class MathGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Model model = Iterators.<Model>filter(input.getAllContents(), Model.class).next();
    String _name = model.getName();
    String _plus = (_name + ".java");
    fsa.generateFile(_plus, MathGenerator.compile(model));
  }
  
  protected static String _compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package math_expression;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class MathComputation {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int x;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private External external;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void compute() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      EList<Variable> _variables = model.getVariables();
      for(final Variable variable : _variables) {
        _builder.append("\t\t");
        String _name = variable.getName();
        _builder.append(_name, "\t\t");
        _builder.append(" = ");
        Expression _expression = variable.getExpression();
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>();
        String _compileExp = MathGenerator.compileExp(_expression, _hashMap);
        _builder.append(_compileExp, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface External {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public int sqrt(int n);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  protected static String _compileExp(final Expression expression, final Map<String, Integer> localVariables) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field value is undefined for the type Expression & Number");
  }
  
  public static String compile(final Model model) {
    return _compile(model);
  }
  
  public static String compileExp(final Expression expression, final Map<String, Integer> localVariables) {
    return _compileExp(expression, localVariables);
  }
}
