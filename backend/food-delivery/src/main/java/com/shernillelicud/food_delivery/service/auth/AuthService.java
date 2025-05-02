package com.shernillelicud.food_delivery.service.auth;

import com.shernillelicud.food_delivery.dto.auth.AuthDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.repository.UserRepository;
import com.shernillelicud.food_delivery.request.auth.LoginRequest;
import com.shernillelicud.food_delivery.request.auth.RegisterRequest;
import com.shernillelicud.food_delivery.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public User register(RegisterRequest request) throws Exception {

//        Check if existing user exists
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if(existingUser.isPresent()) {
            throw new Exception("User already exists");
        }

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();


        return userRepository.save(user);

    }

    @Override
    public User auth(LoginRequest request) {

        try {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid email or password");
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication failed");
        }

        return userRepository.findByEmail(request.getEmail()).orElseThrow();

    }

    @Override
    public AuthDto convertToDto(User user) {

        String jwtToken = jwtService.generateToken(user);

        AuthDto authDto = modelMapper.map(user, AuthDto.class);
        authDto.setToken(jwtToken);

        return authDto;

    }
}
