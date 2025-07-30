package poc_abc.fake_loan_api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import poc_abc.fake_loan_api.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
    // Métodos customizados podem ser adicionados aqui

    Optional<Account> findByAccountNumber(String accountNumber);
}
