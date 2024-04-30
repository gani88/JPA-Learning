package org.example.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name="user_sequence", sequenceName = "user_sequence_name", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)                            // One-to-one relationship annotation with cascade option
    @JoinColumn(name = "address_id", referencedColumnName = "id")   // Join column to specify which column to join, in this case is detail
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
