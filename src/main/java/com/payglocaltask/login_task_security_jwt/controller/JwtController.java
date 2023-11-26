package com.payglocaltask.login_task_security_jwt.controller;

import com.payglocaltask.login_task_security_jwt.model.JwtRequest;
import com.payglocaltask.login_task_security_jwt.model.JwtResponse;
import com.payglocaltask.login_task_security_jwt.services.CustomUserDetailsService;
import com.payglocaltask.login_task_security_jwt.helper.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials", e);
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        // You can access other details from the User object
        String email = ((UserDetails) userDetails).getUsername(); // Assuming email is stored as username

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT " + token);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}