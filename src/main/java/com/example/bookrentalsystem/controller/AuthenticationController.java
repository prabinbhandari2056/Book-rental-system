package com.example.bookrentalsystem.security;


import com.example.bookrentalsystem.model.authentication.AuthenticationRequest;
import com.example.bookrentalsystem.model.authentication.AuthenticationResponse;
import com.example.bookrentalsystem.security.AuthenticationProvider;
import com.example.bookrentalsystem.security.CustomUserDetailsService;
import com.example.bookrentalsystem.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookrental/authenticate")
class AuthenticationController {
    @Autowired
    private AuthenticationProvider authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @PostMapping("")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}