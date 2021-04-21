package org.thefarm.tweb.jpa;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private String name;
    private int price;
    private String type;
    private String descricao;
    private String imagename;


    public Product(String name, int price, String descricao, String type, String imagename) {
        this.name = name;
        this.price = price;
        this.descricao = descricao;
        this.type = type;
        this.imagename = imagename;


    }
    public String toString() {
        return String.format(
                "Product[id=%d, name='%s', price='%s', descricao='%s']",
                id, name, price, descricao);
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getType() {
        return type;
    }

    public String getImagename() {
        return imagename;
    }
}
