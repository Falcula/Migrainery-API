package com.example.Migrainery;
import com.example.Migrainery.authentication.JWTRequest;
import com.example.Migrainery.authentication.JWTResponse;
import com.example.Migrainery.services.MyUserDetailsService;
import com.example.Migrainery.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

public class HomeController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/")
    public String home(){
        return "Hi there";
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate (@RequestBody JWTRequest jwtRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch(BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails =
                myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JWTResponse(token);
    }


}
