package com.salutlume.salutlume;

import com.salutlume.salutlume.Services.UserRepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource datasource;

    @Autowired
    private UserRepositoryUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/signup", "/h2-console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .permitAll()
                .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                .and()
                    .csrf()
                    .ignoringAntMatchers("/h2-console/**")
                ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//             .passwordEncoder(passwordEncoder())
//             .withUser("user")
//             .password(passwordEncoder().encode("parola"))
//             .roles("USER");

        auth.jdbcAuthentication()
                .dataSource(datasource)
                .usersByUsernameQuery("select username, password, 'true' as enabled " +
                        "              from users " +
                        "              where username=?");


        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
