package br.com.fiap.MyPass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyPassApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPassApplication.class, args);
	}

	@GetMapping("/home")
	public String home(){
		return "oi";
	}

}
