package org.example.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "products") // anotasi ini harus ada kalo mau ada di tablenya
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    @SequenceGenerator(name="my_sequence", sequenceName = "my_sequence_name", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "price")
    private Long price;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
