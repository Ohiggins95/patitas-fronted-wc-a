package pe.edu.cibertec.patitas_fronted._wc_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatitasFrontedWcAApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatitasFrontedWcAApplication.class, args);
	}

}
