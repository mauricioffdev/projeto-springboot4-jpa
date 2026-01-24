package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Annotations para que seja uma entidade do meu sistema gerenciada pelo JPA

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    // Número de versão para garantir compatibilidade se a classe mudar (padrão da interface Serializable)
    private static final long serialVersionUID = 1L;

    @Id //Fala pro JAP que o id é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Fala pro JPA que a chave é auto incrementável no banco
    private Long Id;
    private String name;

    private Set<Product> products = new HashSet<>(); //Associação com produto

    public Category() {
    }

    public Category(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return Objects.equals(Id, category.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
