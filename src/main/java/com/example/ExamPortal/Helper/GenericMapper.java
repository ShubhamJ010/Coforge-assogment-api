package com.example.ExamPortal.Helper;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.Dto.AddressDto;
import com.example.ExamPortal.Model.Dto.UserDto;
import com.example.ExamPortal.Model.User;

public class GenericMapper {

    public static User UserDtoToUserEntity(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .gender(userDto.getGender())
                .comments(userDto.getComments())
                .password(userDto.getPassword())
                .address(GenericMapper.AddressDtoToAddressEntity(userDto.getAddress()))
                .build();
    }

    public static Address AddressDtoToAddressEntity(AddressDto addressDto) {
        return Address.builder()
                .city(addressDto.getCity())
                .streetNumber(addressDto.getStreetNumber())
                .country(addressDto.getCountry())
                .build();
    }
}
