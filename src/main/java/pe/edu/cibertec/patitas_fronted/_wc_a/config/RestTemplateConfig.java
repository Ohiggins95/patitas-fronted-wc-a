package pe.edu.cibertec.patitas_fronted._wc_a.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplateAutenticacion(RestTemplateBuilder builder){
        return builder
                .rootUri("http://localhost:8081/autenticacion")
                .setReadTimeout(Duration.ofSeconds(10)) // time out de lectura - tiempo de espera maximo para recibir la respuesta total
                .build();

    }


    @Bean
    public RestTemplate restTemplateFinanzas(RestTemplateBuilder builder){
        return builder
                .rootUri("http://localhost:8081/finanzas")
                .setConnectTimeout(Duration.ofSeconds(5)) //tiempo de espera maximo para establecer conexion
                .setReadTimeout(Duration.ofSeconds(30)) // time out de lectura - tiempo de espera maximo para recibir la respuesta total
                .build();

    }

    @Bean
    public RestTemplate restTemplateReporteria(RestTemplateBuilder builder){
        return builder
                .rootUri("http://localhost:8081/reporteria")
                .setReadTimeout(Duration.ofSeconds(10)) // time out de lectura - tiempo de espera maximo para recibir la respuesta total
                .build();

    }

}





