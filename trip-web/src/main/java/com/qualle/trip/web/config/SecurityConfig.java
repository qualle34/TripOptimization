package com.qualle.trip.web.config;

import com.qualle.trip.web.controller.handler.AuthenticationHandler;
import com.qualle.trip.web.service.UserService;
import com.qualle.trip.web.service.security.RestUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder encoder;
    private final UserDetailsService userDetailsServiceImpl;
    private final AuthenticationHandler handler;

    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/product/**", "/products/**", "/search/**", "/about", "/vacancies/**", "/error/**", "/service").permitAll()
                .antMatchers("/js/**", "/css/**", "/img/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(handler)
                .failureHandler(handler)
                .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler(handler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new RestUserDetailsService(userService);
    }
}
