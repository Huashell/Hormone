package com.example.hormone.config;

import com.example.hormone.security.fliter.JwtAuthenticationTokenFilter;
import com.example.hormone.security.handler.CustomAccessDeniedHandler;
import com.example.hormone.security.handler.UnAuthorizedEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Resource
    private UnAuthorizedEntryPoint unAuthorizedEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .loginPage("/index.html")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
//                        "/index.html",
//                        "/css/**",
//                        "/js/**",

                        "/doc.html",
                        "/webjars/**",
                        "/swagger-resources",
                        "/v3/api-docs",
                        "/favicon.ico"
                )
                .permitAll()
                .antMatchers("/user/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter() , UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler)
                .authenticationEntryPoint(unAuthorizedEntryPoint)
                .and()
                .userDetailsService(userDetailsService);
    }
}
