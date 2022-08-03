package com.example.springsecurity.config;

import com.example.springsecurity.security.CustomAuthenticationProvider;
import com.example.springsecurity.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeHttpRequests()
//                .antMatchers("/dashboard").authenticated()
//                .antMatchers("/home","/other").permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/register","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("bushan").password("12345").authorities("admin")
//                .and()
//                .withUser("pavan").password("12345").authorities("user")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withUsername("bushan").password("12345").authorities("admin").build();
//        UserDetails user2 = User.withUsername("pavan").password("12345").authorities("user").build();
//        userDetailsService.createUser(user1);
//        userDetailsService.createUser(user2);
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider);
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
