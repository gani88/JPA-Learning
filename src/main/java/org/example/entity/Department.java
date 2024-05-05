package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "department_sequence", allocationSize = 1)
//    @Column (name = "department_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;


    @OneToMany(mappedBy = "department") // jika enggak pake mapped by maka akan menganggap ada dua relasi, maka harus dua arah dengan mapped by
    private List<Employee> employees;

    public Department() {
    }

    public Department(List<Employee> employees, String name) {
        this.employees = employees;
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

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
}
