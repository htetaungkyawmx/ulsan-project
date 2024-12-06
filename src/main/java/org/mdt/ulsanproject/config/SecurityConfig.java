package org.mdt.ulsanproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/refresh").permitAll()
                        .requestMatchers("/companies/**").permitAll()
                        .requestMatchers("/document/**").permitAll()
                        .requestMatchers("/drone/**").permitAll()
                        .requestMatchers("/feedback/**").permitAll()
                        .requestMatchers("/flight_log/**").permitAll()
                        .requestMatchers("/help_center/**").permitAll()
                        .requestMatchers("/maintenance/**").permitAll()
                        .requestMatchers("/photo/**").permitAll()
                        .requestMatchers("/report/**").permitAll()
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/vessel/**").permitAll()
                        .requestMatchers("/video/**").permitAll()
                        .requestMatchers("/roles").hasRole("ADMIN")
                        .requestMatchers("/permissions/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
