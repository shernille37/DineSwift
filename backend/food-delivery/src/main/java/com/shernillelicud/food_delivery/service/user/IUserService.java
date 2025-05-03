package com.shernillelicud.food_delivery.service.user;

import com.shernillelicud.food_delivery.dto.user.UserDto;
import com.shernillelicud.food_delivery.model.Address;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.user.NewAddressRequest;

public interface IUserService {

    public User findUserByJwtToken(String token);

    public User addAddress(NewAddressRequest request, User user);

    public UserDto convertToDto(User user);


}
