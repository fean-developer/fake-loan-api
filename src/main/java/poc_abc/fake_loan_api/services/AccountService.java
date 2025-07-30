package poc_abc.fake_loan_api.services;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import poc_abc.fake_loan_api.model.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import poc_abc.fake_loan_api.model.Account;
import poc_abc.fake_loan_api.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    // Métodos de serviço para manipular contas podem ser adicionados aqui
    // Exemplo: criar, atualizar, deletar contas, etc.

    public Account createAccount(String userId) {
        Optional<User> userOpt = userService.getUserById(userId);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
        Account account = Account.builder()
                .user(userOpt.get())
                .accountNumber(generateAccountNumber()) // Gerar número de conta único
                .balance(BigDecimal.valueOf(5000)) // Inicializar saldo como 5000
                .accountType("SAVINGS") // Tipo de conta padrão
                .build();

        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    private String generateAccountNumber() {
        // Lógica para gerar um número de conta único
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

}
