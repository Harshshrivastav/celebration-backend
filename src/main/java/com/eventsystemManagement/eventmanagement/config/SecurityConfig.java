package com.eventsystemManagement.eventmanagement.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/auth/**").permitAll() // Allow access to the register and login endpoint
	            .requestMatchers("/api/auth/**").authenticated()
	            .anyRequest().permitAll()
	        )
	        .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
	        .csrf().disable()
	        .cors().configurationSource(new CorsConfigurationSource() {
	            @Override
	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	                CorsConfiguration cfg = new CorsConfiguration();
	                cfg.setAllowedOrigins(Arrays.asList(
	                    "http://localhost:3000", // React
	                    "http://localhost:4200",  // Angular
	                    "https://celebration-frontend.vercel.app/"  //Deployed 
	                ));
	                cfg.setAllowedMethods(Collections.singletonList("*"));
	                cfg.setAllowCredentials(true);
	                cfg.setAllowedHeaders(Collections.singletonList("*"));
	                cfg.setExposedHeaders(Arrays.asList("Authorization"));
	                cfg.setMaxAge(3600L);
	                return cfg;
	            }
	        })
	        .and()
	        .httpBasic()
	        .and()
	        .formLogin();
	    
	    return http.build();
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
