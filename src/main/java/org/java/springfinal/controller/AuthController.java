package org.java.springfinal.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.java.springfinal.dto.JwtAuthToken;
import org.java.springfinal.dto.LoginDto;
import org.java.springfinal.dto.RegisterDto;
import org.java.springfinal.model.User;
import org.java.springfinal.repository.UserRepository;
import org.java.springfinal.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;


//    @PostMapping("/login")
//    public JwtAuthToken login(@RequestBody LoginDto dto) throws ServletException, IOException {
//        JwtAuthToken token = authService.loginUser(dto);
//        if(token == null){
//            return null;
//        }else{
//            return token;
//        }
//    }
//
    @PostMapping("/register")
    public JwtAuthToken register(@RequestBody RegisterDto dto){
        return authService.registerUser(dto);

    }


    @PostMapping("/login")
    public User login(@RequestBody LoginDto dto) throws ServletException , IOException{
        Optional<User> userOptional = userRepository.findByUsername(dto.getUsername());
        JwtAuthToken jwtToken = authService.loginUser(dto);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            String token = jwtToken.getToken();
            user.setToken(token);
            return user;
        }
        return null;
    }

    @GetMapping("/logout")
    public void logout(){
        authService.logoutUser();
    }

}
