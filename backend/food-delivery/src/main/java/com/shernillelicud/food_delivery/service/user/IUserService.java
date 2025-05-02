package com.shernillelicud.food_delivery.service.user;

import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.User;

public interface IUserService {

    public User findUserByJwtToken(String token);

    public UserDto convertToDto(User user);

}
