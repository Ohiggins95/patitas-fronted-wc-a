package pe.edu.cibertec.patitas_fronted._wc_a.config;

import feign.Request;
import org.springframework.context.annotation.Bean;

public class AutenticacionFeingConfig {

    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(10000, 10000);
    }
}
