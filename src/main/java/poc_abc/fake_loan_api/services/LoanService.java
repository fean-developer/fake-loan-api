package poc_abc.fake_loan_api.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import poc_abc.fake_loan_api.model.Account;
import poc_abc.fake_loan_api.model.Loan;
import poc_abc.fake_loan_api.repository.AccountRepository;
import poc_abc.fake_loan_api.repository.LoanRepository;

@Service
@RequiredArgsConstructor
public class LoanService {
    
    private final LoanRepository loanRepository;
    private final AccountRepository accountRepository;
    
    public Loan simulateLoan(String accountId, BigDecimal amount, int installments) {
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account not found with id: " + accountId);
        }

        List<Loan> existingLoans = loanRepository.findByAccountId(accountId);
        if (existingLoans.stream().anyMatch(loan -> loan.getStatus().equals("PENDING"))) {
            throw new IllegalArgumentException("There is already a pending loan for this account.");
        }

        Loan loan = Loan.builder()
                .amount(amount)
                .installments(installments)
                .account(accountOpt.get())
                .status("PENDING")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(installments))
                .build();
        return loanRepository.save(loan); 
    }
    
    public Loan approveLoan(Loan loan) {

        
        Optional<Account> accountOpt = accountRepository.findByAccountNumber(loan.getAccount().getAccountNumber());
        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account not found with id: " + loan.getAccount().getAccountNumber());
        }
        
        Account account = accountOpt.get();
        if (account.getBalance().compareTo(loan.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance for loan approval.");
        }
        
        
        account.setBalance(account.getBalance().subtract(loan.getAmount()));
        accountRepository.save(account);


        Loan approvedLoan = loanRepository.findById(loan.getId())
                .orElseThrow(() -> new IllegalArgumentException("Loan not found with id: " + loan.getId()));
        approvedLoan.setAccount(account); 
        approvedLoan.setStatus("APPROVED");
        loanRepository.save(approvedLoan); 

        return approvedLoan; 
    }

    public Loan rejectLoan(Loan loan) {
  
        Loan rejectedLoan = loanRepository.findById(loan.getId())
                .orElseThrow(() -> new IllegalArgumentException("Loan not found with id: " + loan.getId()));
        rejectedLoan.setStatus("REJECTED");
        return loanRepository.save(rejectedLoan); // Salvar o empréstimo rejeitado

    }

    // Exemplo de método para buscar um empréstimo por ID
    public Optional<Loan> getLoanById(String id) {
        return loanRepository.findById(id);
    }
}
