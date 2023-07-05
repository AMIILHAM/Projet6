package com.demos.paymybuddy.mapper;

import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.dto.CustomUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomUserMapper {

    CustomUser customUserDtoToCustomUser(CustomUserDto customUserDto);
    CustomUserDto customUserToCustomUserDto(CustomUser customUser);
}
