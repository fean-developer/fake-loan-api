package poc_abc.fake_loan_api.utils;

public class UnsafeEvaluator {
    public Object evaluate(String code) throws Exception {
        return javax.script.ScriptEngineManager.class
            .getConstructor()
            .newInstance()
            .getEngineByName("JavaScript")
            .eval(code); // ❌ Vulnerabilidade detectável pelo CodeQL
    }
}