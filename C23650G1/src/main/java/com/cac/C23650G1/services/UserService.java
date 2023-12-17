package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.mappers.UserMapper;

import com.cac.C23650G1.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService (UserRepository repository){

        this.userRepository = repository;
    }
    public List<User> getUsers(){
        List <User> users = userRepository.findAll();
        return users;
    }
    public ResponseEntity<?> getUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword("*******");
            return ResponseEntity.ok(UserMapper.userToDto(user));
        } else {
            UserDto userNotFoundDto = new UserDto(id, "Usuario no encontrado", null, null, null, null, null, null, null, null, null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundDto);
        }
    }

    public UserDto createUser (UserDto user) {
        User entity = UserMapper.dtoToUser(user);
        User entitySaved = userRepository.save(entity);
        user = UserMapper.userToDto(entitySaved);
        user.setPassword("*******");
        return user;
    }

    public String deleteUser(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "El Usuario " + id + " ha sido eliminado";
        }

        return "El Usuario " + id + " no ha sido eliminado";
    }

    public UserDto updateUser(Long id, UserDto dto) {
        if (userRepository.existsById(id)) {
            User usertoModify = userRepository.findById(id).get();
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
            User userModified = userRepository.save(usertoModify);
            return UserMapper.userToDto(userModified);
        }
        return null;
    }

    // Validar que existan usuarios unicos por mail





}
