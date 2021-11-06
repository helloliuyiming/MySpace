package me.lym.myspace.core.uims.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.lym.myspace.core.uims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        log.info("SecurityConfig.onAuthenticationFailure", exception);
                        ServletOutputStream outputStream = response.getOutputStream();
                        outputStream.write("request failure, unauthenticated request".getBytes(StandardCharsets.UTF_8));
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        outputStream.flush();
                        outputStream.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        Gson gson = new Gson();
                        ServletOutputStream outputStream = response.getOutputStream();
                        outputStream.write(gson.toJson(authentication).getBytes(StandardCharsets.UTF_8));
                        outputStream.flush();
                        outputStream.close();
                    }
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        log.error("SecurityConfig.commence", authException);
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        ServletOutputStream outputStream = response.getOutputStream();
                        outputStream.write("request failure!!!\n".getBytes(StandardCharsets.UTF_8));
                        if (authException instanceof InsufficientAuthenticationException) {
                            outputStream.write(authException.getMessage().getBytes(StandardCharsets.UTF_8));
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                })
                .and().csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
