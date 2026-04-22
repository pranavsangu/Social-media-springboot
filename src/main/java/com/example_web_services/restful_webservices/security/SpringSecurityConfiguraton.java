package com.example_web_services.restful_webservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SpringSecurityConfiguraton {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        //1) all requests are authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        //2) if a raquest is not authenthicated a web page shown
        http.httpBasic(withDefaults());
        //3) didable csrf- for post and put
        // http.csrf().disable();
        http.csrf(csrf -> csrf.disable());

        //change
        return http.build();
    }

}
