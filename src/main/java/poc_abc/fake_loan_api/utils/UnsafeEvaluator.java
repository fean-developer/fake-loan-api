package poc_abc.fake_loan_api.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class UnsafeEvaluator {
    public Object evaluate(String userInput) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        return engine.eval(userInput); // <-- Este padrão é detectado
    }
}