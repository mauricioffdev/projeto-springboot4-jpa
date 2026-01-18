package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//annotation - recurso web implementado por um controlador REST
@RestController
@RequestMapping(value = "/users") //nome do caminho baseado entidade user
public class UserResource {

    //endpoint pra acessar usuarios (É um generic)

    @GetMapping //Pra indicar que o metodo responde a requisicao do HTTP
    public ResponseEntity<User> findAll() { //Metodo findAll
        User user = new User(1L, "Maira","maira@gmail.com", "999999","12345");
        return ResponseEntity.ok().body(user);
    }
}
