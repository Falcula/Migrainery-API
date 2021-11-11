package com.example.Migrainery.authentication;

import com.example.Migrainery.authentication.services.MyUserDetailsService;
import com.example.Migrainery.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       final String authorizationHeader = request.getHeader("Authorization");

       String userName = null;
       String token = null;

       if(authorizationHeader != null && authorizationHeader.startsWith("Bearer" )) {
            token = authorizationHeader.substring(7);
            userName = jwtUtility.getUsernameFromToken(token);
       }

       if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           UserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);

           if(jwtUtility.validateToken(token, userDetails)) {
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }

       }

       filterChain.doFilter(request, response);

    }
}
