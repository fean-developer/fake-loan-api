/**
 * @name Unsafe ScriptEngine.eval usage
 * @description Use of ScriptEngine.eval() is dangerous and can lead to code injection vulnerabilities.
 * @kind path-problem
 * @problem.severity error
 * @id java/unsafe-script-eval
 * @tags security external/cwe/cwe-94
 */

import java

from MethodCall call
where
  call.getMethod().hasQualifiedName("javax.script", "ScriptEngine", "eval")
select call, "Call to ScriptEngine.eval() may lead to code injection."
