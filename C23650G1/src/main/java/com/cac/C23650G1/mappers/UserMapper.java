package com.cac.C23650G1.mappers;
import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserMapper {
    public static User dtoToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setDni(dto.getDni());
        user.setAddress(dto.getAddress());
        user.setBirthday_date(dto.getBirthday_date());
        user.setEmail(dto.getEmail());
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        return user;
    }

    public static UserDto userToDto(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setDni(user.getDni());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setBirthday_date(user.getBirthday_date());
        dto.setCreated_at(user.getCreated_at());
        dto.setUpdate_at(user.getUpdated_at());
        return dto;
    }
}
