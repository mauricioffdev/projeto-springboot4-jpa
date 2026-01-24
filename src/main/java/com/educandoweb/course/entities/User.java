package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user") //renomeia a tabela do banco pra evitar conflito
public class User implements Serializable {
    // Número de versão para garantir compatibilidade se a classe mudar (padrão da interface Serializable)
    private static final long serialVersionUID = 1L;

    @Id //Fala pro JAP que o id é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Fala pro JPA que a chave é auto incrementável no banco
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    // Coleção, recebe apenas o Get
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    //Como estou usando framework, obrigatório o construtor vazio
    public User(){
    }

    //Construtor que recebe os dados e faz as atribuições
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //Comparar um objeto com outro
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
