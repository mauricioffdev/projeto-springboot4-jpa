package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //O spring faz a injeção de dependência
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    //Metodo para buscar um único usuário por ID (findById)
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    //Operação para retornar o usuário salvo
    public User insert(User obj) {
        return repository.save(obj); //Metodo save retona o obj salvo
    }

    public void delete(Long id){
        repository.deleteById(id); //Deletar usuario
    }
}
