package poc_abc.fake_loan_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import poc_abc.fake_loan_api.commons.LoanRequest;
import poc_abc.fake_loan_api.model.Loan;
import poc_abc.fake_loan_api.services.LoanService;


@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/simulate")
    public ResponseEntity<Loan> simulate(@RequestBody LoanRequest request) {
        Loan loan = loanService.simulateLoan(request.getAccountId(), request.getAmount(), request.getInstallments());
        return ResponseEntity.ok(loan);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Loan> approve(@PathVariable String id) {
        return loanService.getLoanById(id)
                .map(loanService::approveLoan)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<Loan> reject(@PathVariable String id) {
        return loanService.getLoanById(id)
                .map(loanService::rejectLoan)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
