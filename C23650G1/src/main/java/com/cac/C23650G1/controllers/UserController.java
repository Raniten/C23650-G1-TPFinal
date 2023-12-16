package com.cac.C23650G1.controllers;

import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.UserDto;
import com.cac.C23650G1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Establecemos que mapee las request por defecto tenemos (http://localhost:8080)
// en la siguiente linea le indicamos que todas las request deben contener /api/users
@RequestMapping(value = "/api/users")
// todos los metodos van a ser /api/user, solo cambia al consultar userById, editar o borrar un user
public class UserController {

    // Necesito obtener una instancia del servicio de usuarios
    @Autowired
    private UserService service;

    // Vamos a obtener una lista de usuarios registrados
    @GetMapping
    //Para acceder a este recurso deben colocar "/users", como ya esta seteado en el request Mapping no hace falta colocarle el (value ="/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());
    }

    // Obtener los datos de un usuario en particular por su ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    // Crear/Dar de alta un Usuario
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createUser(user));
    }

    // En este caso esta unificado, utilizamos el mismo metodo para modificar Parcial (PATCH) o Totalmente (PUT) un usuario

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id, user));
    }

    //Metodo DELETE eliminar usuario
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }

}
