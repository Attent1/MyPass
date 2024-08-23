package br.com.fiap.MyPass.password;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pass")
public class PasswordController {

    private final PasswordRepository passwordRepository;

    public PasswordController(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    @GetMapping
    public List<Password> getAllPass(){
        return passwordRepository.findAll();
    }

}
