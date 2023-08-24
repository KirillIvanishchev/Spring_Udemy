package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//@Configuration class is the class for settings into the application.
// In this class is an example of how to use spring security.
@Configuration
public class DemoSecurityConfig {


    // InMemoryUserDetailsManager is a class that contains new USERS with PASSWORDS and ROLES.
    // Because this is @Configuration class, it will be used in the working application automatically.
    // So, as a BEAN, we will become new USERS, that can be used into LOGIN menu.
    //This class creates USERS and ROLES within the application.

/*    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails Kirill = User.builder()
                .username("Kirill")
                .password("{noop}test")
                .roles("GameDesigner")
                .build();

        UserDetails Kostia = User.builder()
                .username("Kostia")
                .password("{noop}test")
                .roles("GameDeveloper")
                .build();

        UserDetails Igor = User.builder()
                .username("Igor")
                .password("{noop}test")
                .roles("NetDev")
                .build();

        return new InMemoryUserDetailsManager(Kirill, Kostia, Igor);
    }*/


    //Add support for JDBC for Users and Roles.
    //We used 04-setup-spring-security-demo-database-plaintext.sql script to create users and roles
    //in DB.
    //This Bean is ONLY supports BASIC tables and columns. These columns and tables are in SQL script.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        //This return is ONLY supports BASIC tables and columns. These columns and tables are in SQL script.
        //return new JdbcUserDetailsManager(dataSource);

        //This code is for CUSTOM DB logic.
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }

    //Here we are CONFIGURING roles permissions.
    //For example, we have ROLE_GAME_DEVELOPER, ROLE_GAME_DEVELOPER, ROLE_NET_DEVELOPER
    //This roles will be having different permissions for REST APIs.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpRequest) throws Exception {
        httpRequest.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("GameDesigner", "GameDeveloper", "NetDev")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("GameDesigner", "GameDeveloper", "NetDev")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("GameDeveloper", "NetDeveloper")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("GameDeveloper", "NetDeveloper")
                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("GameDeveloper", "NetDeveloper")
                .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("NetDeveloper")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("NetDeveloper")
        );

        //This is for using BASIC HTTP Authentication.
        httpRequest.httpBasic(Customizer.withDefaults());

        //Disable CSRF, just for comfort. BUT in general we need to use it in any WEB application.
        // In any ACTION with REST services.
        httpRequest.csrf(csrf -> csrf.disable());

        return httpRequest.build();
    }
}
