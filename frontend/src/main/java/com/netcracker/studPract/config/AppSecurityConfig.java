package com.netcracker.studPract.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?").passwordEncoder(new ShaPasswordEncoder(256));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/head/**").access("hasRole('ROLE_HEAD')")
                .antMatchers("/profile/**").access("hasRole('ROLE_STUDENT')")
                .antMatchers("/profile/**").access("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMIN','ROLE_HEAD')")
                .and()
                .headers()
                .frameOptions().sameOrigin().httpStrictTransportSecurity().disable().and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(authSuccessHandler)
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .csrf();

    }

}
