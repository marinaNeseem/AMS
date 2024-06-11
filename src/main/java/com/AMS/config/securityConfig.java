package com.AMS.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class securityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("seller")
                .password("password")
                .roles("SELLER")
                .build();

        UserDetails supervisor = User.withDefaultPasswordEncoder()
                .username("bidder")
                .password("password")
                .roles("BIDDER")
                .build();
        return new InMemoryUserDetailsManager(admin, supervisor);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/bidder/**").hasRole("BIDDER");
                    auth.requestMatchers("/seller/**").hasRole("SELLER");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
