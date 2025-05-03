package com.shernillelicud.food_delivery.service.user;


import com.shernillelicud.food_delivery.dto.address.AddressDto;
import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.Address;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.repository.UserRepository;
import com.shernillelicud.food_delivery.request.user.NewAddressRequest;
import com.shernillelicud.food_delivery.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User addAddress(NewAddressRequest request, User user) {

        Address address = request.getAddress();

        if(user.getAddresses().contains(address))
            user.getAddresses().remove(address);
        else
            user.getAddresses().add(address);

        return userRepository.save(user);
    }

    @Override
    public UserDto convertToDto(User user) {

        UserDto userDto = new UserDto();
        modelMapper.map(user, userDto);

        userDto.setFullname(user.getFirstname() + " " + user.getLastname());

        return userDto;
    }

}
