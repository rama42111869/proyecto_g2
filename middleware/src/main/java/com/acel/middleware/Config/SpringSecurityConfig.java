package com.acel.middleware.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class SpringSecurityConfig {
    RSAPublicKey key;

	RSAPrivateKey priv;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
            .authorizeHttpRequests((authorize) -> authorize
                .anyRequest().permitAll()
            )
            .csrf((csrf) -> csrf.disable());
		return http.build();
	}
}
