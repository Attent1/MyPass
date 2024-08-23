package br.com.fiap.MyPass.password;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "passwords")
@Data
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String url;
    String username;
    String password;

}
