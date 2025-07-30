package poc_abc.fake_loan_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc_abc.fake_loan_api.utils.UnsafeEvaluator;

@RestController
@RequestMapping("/test")
public class VulnerableController {

    @GetMapping("/eval")
    public String runEval(@RequestParam String code) throws Exception {
        UnsafeEvaluator evaluator = new UnsafeEvaluator();
        Object result = evaluator.evaluate(code);
        return "Result: " + result;
    }

    @GetMapping("/eval")
    public String runEvalExc(@RequestParam String code) throws Exception {
        return "Output: " + new UnsafeEvaluator().evaluate(code);
    }
}