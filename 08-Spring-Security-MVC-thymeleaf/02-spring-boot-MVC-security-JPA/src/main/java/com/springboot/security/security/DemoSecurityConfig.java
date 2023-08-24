package com.springboot.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DemoSecurityConfig {

/*    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails testUser = User.builder()
                .username("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        UserDetails testDeveloper = User.builder()
                .username("developer")
                .password("{noop}developer")
                .roles("USER", "DEVELOPER")
                .build();

        UserDetails testAdmin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("USER", "DEVELOPER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(testUser, testDeveloper, testAdmin);
    }*/

    // support for JDBC, no hardcoded Users.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain customLoginForm(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurator ->
                                    configurator
                                            .requestMatchers("/")
                                            .hasAnyRole("USER", "DEVELOPER", "ADMIN")
                                            .requestMatchers("/developers/**")
                                            .hasAnyRole("DEVELOPER","ADMIN")
                                            .requestMatchers("/admins/**")
                                            .hasRole("ADMIN")
                                            .anyRequest().authenticated()
                                    )
                                    .formLogin(form ->
                                                form.loginPage("/login")
                                                    .loginProcessingUrl("/authenticationCheck")
                                                    .permitAll()
                                                )
                                    .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }
}
