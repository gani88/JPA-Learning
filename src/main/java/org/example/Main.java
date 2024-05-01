package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // harus membuat entity manager factory untuk jpa
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("belajarJPA");

        // Create EntityManager ,object yang mengelola object yang kita punya
        EntityManager em = emf.createEntityManager();

        // Begin Transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        For Product (SINGLE ENTITY)
//        Product newProduct1 = new Product();
//        newProduct1.setName("Sabun");
//        newProduct1.setPrice(5000L);

        Book newBook1 = new Book();
        newBook1.setBookName("Intro to Algebra");
        newBook1.setAuthor("Erick K.");
        em.persist(newBook1);

//        For 1-to-1 Relationship
//        Address newAddress1 = new Address();
//        newAddress1.setStreet("Jl. Dewantoro");
//        newAddress1.setCity("Yogyakarta");
//
//        User newUser1 = new User();
//        newUser1.setAddress(newAddress1);



//        For Many-to-Many Relationship
//        Student newStudent1 = new Student();
//        newStudent1.setName("Lyle");
//        Student newStudent2 = new Student();
//        newStudent2.setName("Anwar");
//
//        Course newCourse1 = new Course();
//        newCourse1.setName("Linguist");
//        Course newCourse2 = new Course();
//        newCourse2.setName("Economy");
//
//
//        // Create the relationships
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(newStudent1);
//        studentList.add(newStudent2);
//
//        List<Course> courseList = new ArrayList<>();
//        courseList.add(newCourse1);
//        courseList.add(newCourse2);
//
//        // Assign
//        newCourse1.setStudents(studentList);
//        newCourse2.setStudents(studentList);
//
//        newStudent1.setCourses(courseList);
//        newStudent2.setCourses(courseList);
//
//        em.persist(newCourse1);
//        em.persist(newCourse2);
//        em.persist(newStudent1);
//        em.persist(newStudent2);
        transaction.commit();

        // Close Transaction / EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}