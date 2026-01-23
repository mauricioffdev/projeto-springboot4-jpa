package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired //O spring faz a injeção de dependência
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    //Metodo para buscar um único usuário por ID (findById)
    public Category findByid(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
