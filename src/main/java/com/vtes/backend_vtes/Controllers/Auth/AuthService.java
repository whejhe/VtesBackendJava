package com.vtes.backend_vtes.Controllers.Auth;

import org.springframework.stereotype.Service;

import com.vtes.backend_vtes.Entities.User;
import com.vtes.backend_vtes.Jwt.JwtService;
import com.vtes.backend_vtes.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(LoginRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .build();
        
            userRepository.save(user);

            return AuthResponse.builder()
                .token(jwtService.getToken(null, user))
                .build();
    }

}
