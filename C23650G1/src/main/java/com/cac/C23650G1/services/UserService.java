package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.mapper.UserMapper;

import com.cac.C23650G1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService (UserRepository repository){

        this.repository = repository;
    }
    public List<User> getUsers(){
        List <User> users = repository.findAll();
        return users;
    }
    public UserDto getUserById(Long id){
        User user = repository.findById(id).get();
        user.setPassword("*******");
        return UserMapper.userToDto(user);
    }

    public UserDto createUser (UserDto user) {
        User entity = UserMapper.dtoToUser(user);
        User entitySaved = repository.save(entity);
        user = UserMapper.userToDto(entitySaved);
        user.setPassword("*******");
        return user;
    }

    public String deleteUser(Long id){
        if (repository.existsById(id)){
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
        } else return null;
    }

    // Validar que existan usuarios unicos por mail





}
