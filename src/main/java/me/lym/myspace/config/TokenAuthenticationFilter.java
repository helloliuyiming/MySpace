package me.lym.myspace.config;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getParameter("token");
        System.out.println("token = " + token);
        if (token == null) {
            chain.doFilter(request,response);
            return;
        }
        SecurityContext context = SecurityContextHolder.getContext();
        if (context.getAuthentication() == null||!context.getAuthentication().isAuthenticated()) {
            System.out.println("TokenAuthenticationFilter.doFilterInternal()");
            TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
            context.setAuthentication(tokenAuthentication);
        }else {
            System.out.println("request is done already");
        }
        chain.doFilter(request,response);
    }
}
