package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    // Número de versão para garantir compatibilidade se a classe mudar (padrão da interface Serializable)
    private static final long serialVersionUID = 1L;

    @Id //Fala pro JAP que o id é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Fala pro JPA que a chave é auto incrementável no banco
    private Long Id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    private Set<Category> categories = new HashSet<>(); //Garante que a coleção não começe nula

    public Product() {
    }

    public Product(Long id, String name, String description, double price, String imgUrl) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() { //N tem Set em coleções
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(Id, product.Id)
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description) && Objects.equals(imgUrl, product.imgUrl);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(Id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Objects.hashCode(imgUrl);
        return result;
    }
}

