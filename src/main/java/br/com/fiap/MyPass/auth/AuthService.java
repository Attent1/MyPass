package br.com.fiap.MyPass.auth;

import br.com.fiap.MyPass.user.User;
import br.com.fiap.MyPass.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public Token login(User user) {
        System.out.println("AAAAAAAAAAAAAA" + user.getUsername());
        System.out.println("BBBBBBBBBBBBB" + user.getPassword());
        var lUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("caiu aqui"));

        if (!passwordEncoder.matches(user.getPassword(), lUser.getPassword()))
            throw new RuntimeException("Access denied32");

        return tokenService.createToken("text", lUser.getUsername());
    }

}