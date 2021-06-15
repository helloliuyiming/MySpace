package me.lym.myspace.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    public TokenAuthenticationProvider() {
        System.out.println("TokenAuthenticationProvider.TokenAuthenticationProvider");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("TokenAuthenticationProvider.authenticate():authentication by token is successful");
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println("TokenAuthenticationProvider.supports:" + (TokenAuthentication.class
                .isAssignableFrom(authentication)));
        return (TokenAuthentication.class
                .isAssignableFrom(authentication));
    }
}
