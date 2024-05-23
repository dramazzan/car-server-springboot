package org.java.springfinal.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.java.springfinal.dto.JwtAuthToken;
import org.java.springfinal.dto.LoginDto;
import org.java.springfinal.dto.RegisterDto;
import org.java.springfinal.model.Role;
import org.java.springfinal.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final HttpServletResponse httpServletResponse;

    public JwtAuthToken registerUser(RegisterDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .age(dto.getAge())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(dto.getPassword()))

                .build();

        userService.createUser(user);
        String token = jwtService.generateToken(user);
        return new JwtAuthToken(token);
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect("/auth/login");
    }

    public JwtAuthToken loginUser(LoginDto dto) throws ServletException, IOException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    dto.getUsername(),
                    dto.getPassword()
            ));
        }catch(AuthenticationException e){
            onAuthenticationFailure(null, httpServletResponse , e);
            return null;
        }



        var user = userService
                .userDetailsService()
                .loadUserByUsername(dto.getUsername());

        var token = jwtService.generateToken(user);
        return new JwtAuthToken(token);

    }

    public void logoutUser() {
        SecurityContextHolder.clearContext();
    }

}

