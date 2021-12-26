package com.juniper.onlinesavdo.service;


import com.juniper.onlinesavdo.payload.AuthRequest;
import com.juniper.onlinesavdo.payload.AuthResponce;
import com.juniper.onlinesavdo.repository.UserRepository;
import com.juniper.onlinesavdo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthResponce createToken(AuthRequest authRequest) throws Exception {
        if (userRepository.existsByPhonenumber(authRequest.getPhonenumber()))
        {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authRequest.getPhonenumber(), authRequest.getPassword())
                );
            } catch (BadCredentialsException e) {
                throw new Exception("Password yoki login hato", e);
            }


            final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getPhonenumber());

            final String jwt = jwtUtils.generateToken(userDetails);

            return new AuthResponce(jwt);
        }
        return new AuthResponce("Xatolik");
    }


}
