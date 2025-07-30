package poc_abc.fake_loan_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import poc_abc.fake_loan_api.model.Loan;

public interface LoanRepository extends MongoRepository<Loan, String> {
    // Métodos customizados podem ser adicionados aqui
}
