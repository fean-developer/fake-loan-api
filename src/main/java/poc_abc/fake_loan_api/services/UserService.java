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

    private String AWS_ACCESS_KEY_ID = "AKIAIOSFODNN7EXAMPLE";
    private String AWS_SECRET_ACCESS_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

    // Exemplo de GitHub Webhook Secret
    private String GITHUB_WEBHOOK_SECRET = "whsec_1234567890abcdef1234567890abcdef";

    // Exemplo de GitHub OAuth Token
    private String GITHUB_OAUTH_TOKEN = "gho_1234567890abcdef1234567890abcdef12345678";

    // Exemplo de GitHub Personal Access Token (PAT)
    private String GH_PAT = "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";

    private String MY_SUPER_SECRET = "sk_live_51H8QwLJk9EXAMPLEKEY1234567890abcdef";
    private String INTERNAL_API_TOKEN = "api_tok_1234567890abcdef1234567890abcdef";
    private String CUSTOM_SECRET_KEY = "p@ssw0rd!ThisIsAVerySecretKey123456";

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
