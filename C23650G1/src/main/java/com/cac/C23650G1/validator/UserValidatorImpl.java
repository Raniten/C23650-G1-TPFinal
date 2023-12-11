package com.cac.C23650G1.validator;

import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.exception.ApiUnprocessableEntity;
import com.cac.C23650G1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Component
public class UserValidatorImpl implements UserValidator{
    @Autowired
    private UserRepository repository;



    @Override
    public void validator(UserDto dto) throws ApiUnprocessableEntity {
        if (dto.getUsername().length() < 3) {
            this.message("El nombre de usuario debe tener al menos 3 caracteres");
        }
        if (dto.getUsername().length() > 10){
            this.message("El nombre de usuario debe tener como maximo 10 caracteres");
        }
        if (dto.getDni().length() > 8){
            this.message("El DNI solo puede contener un máximo de 8 caracteres");
        }
        if (!dto.getDni().matches("\\d+")) {
            this.message("El DNI solo puede contener números");
        }
        if (dto.getDni().length() <= 7){
            this.message("El DNI solo puede contener un mínimo de 7 caracteres");
        }
        if (!dto.getEmail().contains("@")) {
            this.message("El correo electrónico debe contener '@'");
        }
        if (!validarPassword(dto.getPassword())) {
            this.message("La contraseña debe contener al menos un número, una letra mayúscula y algún símbolo/caracter especial");
        }
        if (LocalDateTime.now().getYear() - dto.getBirthday_date().getYear() > 18) {
            this.message("Debes ser mayor de 18 años para registrarte");
        }

    }

    private boolean validarPassword(String password) {
        // Validar que la contraseña contenga al menos un número, una letra mayúscula y algún símbolo/caracter especial
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=]).+$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    private void message (String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
