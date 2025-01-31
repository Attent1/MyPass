package br.com.fiap.MyPass.auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public Token createToken(String type, String username) {
        var expirationAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.UTC);
        Algorithm algorithm = Algorithm.HMAC256("assinatura");
        String token = JWT.create()
                .withSubject(type)
                .withSubject(username)
                .withExpiresAt(expirationAt)
                .sign(algorithm);

        return new Token(token, type, username);

    }

}