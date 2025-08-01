package poc_abc.fake_loan_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc_abc.fake_loan_api.model.User;
import poc_abc.fake_loan_api.services.UserService;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // // Endpoint vulnerável para teste de code scanning
    // @GetMapping("/vulnerable")
    // public String vulnerableEndpoint(@RequestParam String cmd) throws java.io.IOException {
    //     Runtime.getRuntime().exec(cmd);
    //     return "Executed: " + cmd;
    // }
}
