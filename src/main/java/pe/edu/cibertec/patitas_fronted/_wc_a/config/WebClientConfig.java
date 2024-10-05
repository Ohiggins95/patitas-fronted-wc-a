package pe.edu.cibertec.patitas_fronted._wc_a.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClientConfigAutenticacion(WebClient.Builder builder) {

            return builder.build();

    }


}
