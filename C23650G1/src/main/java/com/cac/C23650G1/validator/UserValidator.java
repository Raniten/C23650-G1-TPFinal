package com.cac.C23650G1.validator;

import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.exception.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserValidator {
    void validator(UserDto dto) throws ApiUnprocessableEntity;

}
