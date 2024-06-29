package org.example.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurity {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public SecurityFilterChain filteringCriteria(HttpSecurity http) throws Exception {
//        http.cors().disable();
//        http.csrf().disable();
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
//        return http.build();
//    }
}
