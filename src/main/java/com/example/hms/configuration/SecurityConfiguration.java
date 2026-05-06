package com.example.hms.configuration;

import com.example.hms.security.JwtAuthenticationEntryPoint;
import com.example.hms.security.JwtAuthenticationFilter;
import com.example.hms.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtTokenProvider);
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(ex -> ex.authenticationEntryPoint(new JwtAuthenticationEntryPoint()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/contact-queries").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/doctors/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/doctor-specializations").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/doctor-specializations").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/doctor-specializations/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/doctor-specializations/**").hasAuthority("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyAuthority("USER", "DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasAnyAuthority("USER", "DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyAuthority("DOCTOR", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/doctors").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/doctors/**").hasAuthority("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/patients").hasAnyAuthority("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/patients/doctor/**").hasAnyAuthority("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/patients/**").hasAnyAuthority("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/patients/**").hasAnyAuthority("DOCTOR", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/patients/*/medical-history").hasAnyAuthority("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/patients/*/medical-history").hasAnyAuthority("DOCTOR", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/appointments").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/appointments").hasAnyAuthority("USER", "DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/appointments/user/**").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/appointments/doctor/**").hasAnyAuthority("DOCTOR", "ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/appointments/*/cancel-by-user").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/appointments/*/cancel-by-doctor").hasAnyAuthority("DOCTOR", "ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/admin/**").hasAuthority("ADMIN")

                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable());
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
