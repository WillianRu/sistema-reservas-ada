package org.adaschool.sistemareservasada.application.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@Configuration
public class CorsGlobalConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        config.addAllowedOrigin("http://localhost:4200");


        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}*/

@Configuration
public class CorsGlobalConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings (CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Reemplaza con la URL de tu frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
            }

        };
    }
}
