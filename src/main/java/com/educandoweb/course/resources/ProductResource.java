package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//annotation - recurso web implementado por um controlador REST
@RestController
@RequestMapping(value = "/products") //nome do caminho baseado entidade Product
public class ProductResource {

    //Declaração de dependência para o Service
    @Autowired
    private ProductService service;


    //endpoint pra acessar usuarios (É um generic)
    @GetMapping //Pra indicar que o metodo responde a requisicao do HTTP
    public ResponseEntity<List<Product>> findAll() { //Metodo findAll
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint para buscar usuario por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj =service.findByid(id);
        return ResponseEntity.ok(obj);
    }
}
