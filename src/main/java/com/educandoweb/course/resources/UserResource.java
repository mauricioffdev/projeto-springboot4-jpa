package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User obj =service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Inserir usuario
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
