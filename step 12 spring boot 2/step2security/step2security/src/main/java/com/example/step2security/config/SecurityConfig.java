package com.example.step2security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        httpSecurity.csrf(customizer -> customizer.disable());
        httpSecurity.authorizeHttpRequests(request ->
                request.anyRequest().authenticated());
//        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        Customizer<CsrfConfigurer<HttpSecurity>> cust = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//
//        httpSecurity.csrf(cust);

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails userDetails = User
//                .withDefaultPasswordEncoder()
//                .username("kiran")
//                .password("k@123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

     @Bean
     public AuthenticationProvider authenticationProvider(){
          DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//          provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
            provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
          return provider;
     }

}
