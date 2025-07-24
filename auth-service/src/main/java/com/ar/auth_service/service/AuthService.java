package com.ar.auth_service.service;

import com.ar.auth_service.dto.AuthRequest;
import com.ar.auth_service.dto.AuthResponse;
import com.ar.auth_service.entity.User;
import com.ar.auth_service.repository.UserRepository;
import com.ar.auth_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public AuthResponse signup(AuthRequest req) {
        if (repo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword()); // TODO: Hash this!
        repo.save(user);
        String token = jwtUtil.generateToken(req.getUsername());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest req) {
        User user = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
