package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//annotation - recurso web implementado por um controlador REST
@RestController
@RequestMapping(value = "/users") //nome do caminho baseado entidade user
public class UserResource {

    //Declaração de dependência para o Service
    @Autowired
    private UserService service;


    //endpoint pra acessar usuarios (É um generic)
    @GetMapping //Pra indicar que o metodo responde a requisicao do HTTP
    public ResponseEntity<List<User>> findAll() { //Metodo findAll
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint para buscar usuario por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj =service.findByid(id);
        return ResponseEntity.ok(obj);
    }
}
