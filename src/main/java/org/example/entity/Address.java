package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @SequenceGenerator(name="address_sequence", sequenceName = "address_sequence_name", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    // This where the address become foreign key in user
    @OneToOne(mappedBy = "address") // bisa pake @OneToOne atau tidak, jika tidak ditambahkan maka akan jadi unidirectional.. kita mengelola hanya di user saja.
    private User user;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
