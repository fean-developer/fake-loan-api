package poc_abc.fake_loan_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import poc_abc.fake_loan_api.commons.UserRequest;
import poc_abc.fake_loan_api.model.Account;
import poc_abc.fake_loan_api.services.AccountService;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody UserRequest userRequest) {
        Account account = accountService.createAccount(userRequest.getUserId());
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable String id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
