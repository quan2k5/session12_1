package com.data.session12_2.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// Tắt CSRF để đơn giản hoá thử nghiệm (không nên trong production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Cho phép truy cập tự do
                        .anyRequest().authenticated() // Các endpoint khác yêu cầu xác thực
                )
                .httpBasic(withDefaults());// Sử dụng xác thực Basic (hoặc có thể dùng formLogin())

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
