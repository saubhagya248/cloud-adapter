package com.wiz.cloudadapter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .oauth2Login(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req.
                        requestMatchers("/oauth").permitAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .build();
    }
}
