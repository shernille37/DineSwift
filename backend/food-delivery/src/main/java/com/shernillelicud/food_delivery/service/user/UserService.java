package com.shernillelicud.food_delivery.service.user;


import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.repository.UserRepository;
import com.shernillelicud.food_delivery.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public User findUserByJwtToken(String bearerToken) {
        String email = jwtService.extractEmailFromBearer(bearerToken);


        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
