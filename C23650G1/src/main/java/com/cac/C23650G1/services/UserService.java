package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.exception.EntityNotFoundException;
import com.cac.C23650G1.exception.IllegalArgumentException;
import com.cac.C23650G1.mappers.UserMapper;

import com.cac.C23650G1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {

        this.repository = repository;
    }

    public List<User> getUsers() {
        List<User> users = repository.findAll();
        return users;
    }

    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new EntityNotFoundException
            ("No existe el usuario con id " + id + " en la base de datos");
        }
        User user = optionalUser.get();
        user.setPassword("*******");
        return UserMapper.userToDto(user);
    }

    public UserDto createUser(UserDto user) {

        if (user.areAllFieldsNull()) {
            throw new IllegalArgumentException("No se puede crear un usuario sin datos");
        } else if (user.getFirstname() == null || user.getFirstname().isEmpty()) {
            throw new IllegalArgumentException("El campo firstname no puede ser nulo o vacio");
        } else if (user.getLastname() == null || user.getLastname().isEmpty()) {
            throw new IllegalArgumentException("El campo lastname no puede ser nulo o vacio");
        } else if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El campo username no puede ser nulo o vacio");
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("El campo password no puede ser nulo o vacio");
        } else if (user.getDni() == null || user.getDni().isEmpty()) {
            throw new IllegalArgumentException("El campo dni no puede ser nulo o vacio");
        } else if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El campo email no puede ser nulo o vacio");
        } else if (user.getAddress() == null || user.getAddress().isEmpty()) {
            throw new IllegalArgumentException("El campo address no puede ser nulo o vacio");
        }

        if (repository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("El username ya existe");
        }
        if (repository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }
        if (repository.existsByDni(user.getDni())) {
            throw new IllegalArgumentException("El dni ya existe");
        }

        User entity = UserMapper.dtoToUser(user);

        User entitySaved = repository.save(entity);
        user = UserMapper.userToDto(entitySaved);
        user.setPassword("*******");
        return user;
    }

    public String deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "El Usuario " + id + " ha sido eliminado";
        }

        return "El Usuario " + id + " no ha sido eliminado";
    }

    public UserDto updateUser(Long id, UserDto dto) {
        if (repository.existsById(id)) {
            User usertoModify = repository.findById(id).get();
            // Valdiar que datos no vienen en null para setearlos al objeto ya seteado

            if (dto.getFirstname() != null) {
                usertoModify.setFirstname(dto.getFirstname());
            }
            if (dto.getLastname() != null) {
                usertoModify.setLastname(dto.getLastname());
            }
            if (dto.getUsername() != null) {
                usertoModify.setUsername(dto.getUsername());
            }
            if (dto.getPassword() != null) {
                usertoModify.setPassword(dto.getPassword());
            }
            if (dto.getDni() != null) {
                usertoModify.setDni(dto.getDni());
            }
            if (dto.getEmail() != null) {
                usertoModify.setEmail(dto.getEmail());
            }
            if (dto.getAddress() != null) {
                usertoModify.setAddress(dto.getAddress());
            }
            if (dto.getUpdate_at() != null) {
                usertoModify.setUpdated_at(dto.getUpdate_at());
            }
            User userModified = repository.save(usertoModify);
            return UserMapper.userToDto(userModified);
        }
        return null;
    }

    // Validar que existan usuarios unicos por mail

}
