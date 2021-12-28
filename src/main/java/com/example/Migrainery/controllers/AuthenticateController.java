package com.example.Migrainery.controllers;
import com.example.Migrainery.models.JWTRequestModel;
import com.example.Migrainery.models.JWTResponseModel;
import com.example.Migrainery.services.MyUserDetailsService;
import com.example.Migrainery.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class AuthenticateController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JWTResponseModel authenticate (@RequestBody JWTRequestModel jwtRequestModel) throws Exception {


        try{
            System.out.println("test");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequestModel.getUsername(),
                            jwtRequestModel.getPassword()
                    )
            );
        } catch(BadCredentialsException e) {
            System.out.println("test");
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails =
                myUserDetailsService.loadUserByUsername(jwtRequestModel.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JWTResponseModel(token);
    }

}
