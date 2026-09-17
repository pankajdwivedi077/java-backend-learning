package com.example.step2security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {

        return httpSecurity
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

//        Customizer<CsrfConfigurer<HttpSecurity>> cust = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//
//        httpSecurity.csrf(cust);

//         httpSecurity.build();
    }

//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//    httpSecurity.csrf(customizer -> customizer.disable());
//
//    // Allow unauthenticated access to the register endpoint, secure everything else
//    httpSecurity.authorizeHttpRequests(request ->
//            request
//                    .requestMatchers("/api/users/register").permitAll()
//                    .anyRequest().authenticated()
//    );
//
//    httpSecurity.httpBasic(Customizer.withDefaults());
//    httpSecurity.sessionManagement(session ->
//            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//    return httpSecurity.build();
//}

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

     @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration
                                                                    configuration){
       return configuration.getAuthenticationManager();
     }

}
