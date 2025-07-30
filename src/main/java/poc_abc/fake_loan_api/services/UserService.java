package poc_abc.fake_loan_api.services;

import poc_abc.fake_loan_api.model.User;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import poc_abc.fake_loan_api.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Métodos de serviço para manipular usuários podem ser adicionados aqui
    // Exemplo: criar, atualizar, deletar usuários, etc.


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
