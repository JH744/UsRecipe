package com.example.FP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/", "/join","/joinOk", "/findUserid", "/findUseridOk", "/id_check", "/sendEmail", "/mailCheck","/nickname_check","/static/**").permitAll()
                .requestMatchers("/admin/**").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

        http.formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/");

        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login");

        http.httpBasic();


        return http.build();
    }
}