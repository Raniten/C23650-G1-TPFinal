package com.cac.C23650G1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//Establecemos que mapee las request por defecto tenemos (http://localhost:8080)
// en la siguiente linea le indicamos que todas las request deben contener /api/users
@RequestMapping(value = "/api/users")
// todos los metodos van a ser /api/user, solo cambia al consultar userById, editar o borrar un user
public class UserController {

}
