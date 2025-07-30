package poc_abc.fake_loan_api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import poc_abc.fake_loan_api.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    // Métodos customizados podem ser adicionados aqui
    
    @Query("{$or: [{email: ?0}]}")
    Optional<User> findByEmail(String email);
}
