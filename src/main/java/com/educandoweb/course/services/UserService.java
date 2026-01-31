package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Operação para retornar o usuário salvo
    public User insert(User obj) {
        return repository.save(obj); //Metodo save retona o obj salvo
    }

    //Deletar usuario
    public void delete(Long id) {
        // 1. Verifica se o ID existe antes de tentar deletar
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        // 2. Se existe, deleta (agora seguro)
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation"); // <--- Mensagem curta e clara
            //"Não é possível excluir usuário que possui pedidos."
        }
    }

    //Alterar Usuario, getReference prepara o obj pra vc mexer e depois efetuar uma operação,
    // findById traz o obj
    public User update(Long id, User obj) {
        try {
            // Lembrete: getReferenceById substitui o getOne
            User entity = repository.getReferenceById(id);
            updateData(entity, obj); // Metodo auxiliar que atualiza os dados
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            // Aqui o try-catch FUNCIONA, porque o getReferenceById grita quando não acha
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
