package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//annotation - recurso web implementado por um controlador REST
@RestController
@RequestMapping(value = "/categories") //nome do caminho baseado entidade user
public class CategoryResource {

    //Declaração de dependência para o Service
    @Autowired
    private CategoryService service;


    //endpoint pra acessar categorias
    @GetMapping //Pra indicar que o metodo responde a requisicao do HTTP
    public ResponseEntity<List<Category>> findAll() { //Metodo findAll
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint para buscar usuario por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj =service.findByid(id);
        return ResponseEntity.ok(obj);
    }
}
