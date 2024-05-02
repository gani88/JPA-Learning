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
/**
 *  To create an EntityManager, an EntityManagerFactory is needed.
 *  EntityManagerFactory is an interface for interacting with EntityManager.
 *  This is the first step in using JPA in a Java application.
 *  EntityManagerFactory is used to create EntityManager, which is an object responsible
 *  for managing entities and their lifecycle within a persistence context.
 *
 *  Creating Entity Manager Factory
 *  Persistence.createEntityManagerFactory("persistence_unit_name") is used to create EntityManagerFactory.
 *  "persistence_unit_name" is the name of the persistence unit defined in the persistence.xml file.
 *  The persistence.xml file contains configuration for EntityManagerFactory, such as the persistence provider name,
 *  database connection properties, and entity classes to be loaded.
 *         EntityManagerFactory emf = Persistence.createEntityManagerFactory("belajarJPA");
 *
 *  Creating EntityManager
 *  Once the EntityManagerFactory is created, EntityManager can be created using the createEntityManager() method.
 *  EntityManager is an object responsible for managing entities within a persistence context.
 *  It is used to perform database operations such as saving, updating, deleting, and finding entities.
 *         EntityManager em = emf.createEntityManager();
 *
 *  After finishing using EntityManager, make sure to close it to release resources.
 *  Resources used by EntityManager, such as database connections, will be released after EntityManager is closed.
 *  It is a good practice to always close EntityManager when it is no longer needed.
 *  Closing EntityManagerFactory is also recommended after the application finishes running.
 *  This helps avoid resource leaks and improves overall application performance.
 */


        // Untuk membuat EntityManager dibutuhkan EntityManagerFactory.
        // EMF adalah interface untuk berinteraksi dengan EM/membuat EM,
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("belajarJPA");

        // Create EntityManager ,object yang mengelola entity/clas dan lifecyclenya
        EntityManager em = emf.createEntityManager();

        // Begin Transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // ========= Persist/Insert =========
        // For Product (SINGLE ENTITY)
//        Product newProduct1 = new Product();
//        newProduct1.setName("Sabun");
//        newProduct1.setPrice(5000L);

//        Book newBook1 = new Book();
//        newBook1.setBookName("Intro to Algebra");
//        newBook1.setAuthor("Erick K.");
//        em.persist(newBook1);

        // For 1-to-1 Relationship
//        Address newAddress1 = new Address();
//        newAddress1.setStreet("Jl. Dewantoro");
//        newAddress1.setCity("Yogyakarta");
//
//        User newUser1 = new User();
//        newUser1.setAddress(newAddress1);



        // For Many-to-Many Relationship
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


        // For One-to-Many Relationship
        Department newDepartment1 = new Department();
        newDepartment1.setName("Finance");
        em.persist(newDepartment1);

        Employee newEmployee1 = new Employee();
        newEmployee1.setName("Beta");
        newEmployee1.setDepartment(newDepartment1);


        Employee newEmployee2 = new Employee();
        newEmployee2.setName("Ana");
        newEmployee2.setDepartment(newDepartment1);

        em.persist(newEmployee1);
        em.persist(newEmployee2);
        // ========= DELETE =========
//        Student student = em.find(Student.class, 403);
//        em.remove(student);

        // ========= Find/Retrieve =========
//        Student student = em.find(Student.class, 252);
//        System.out.println("Student id      :" + student.getId());
//        System.out.println("Student name    :" + student.getName());
//        System.out.println("Student course  :" + student.getCourses());


        transaction.commit();


        // Close Transaction / EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}