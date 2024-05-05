package org.example;

import jakarta.persistence.*;
import org.example.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/*
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


        // NATIVE QUERY
//        Product newProduct = new Product();
//        newProduct.setId(10L);
//        newProduct.setName("Wafer");
//        newProduct.setPrice(10000L);
//
//        em.createNativeQuery("INSERT INTO products(id, name, price) VALUES (?, ?, ?)")
//                .setParameter(1, newProduct.getId())
//                .setParameter(2, newProduct.getName())
//                .setParameter(3, newProduct.getPrice())
//                .executeUpdate();

        // TypedQuery
        TypedQuery<Product> jpqlQuery = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
        jpqlQuery.setParameter("id", 3);

        Product hasilQuery =  jpqlQuery.getSingleResult();
        System.out.println(hasilQuery.toString());

        // NamedQuery
        Query namedQuery = em.createNamedQuery("Product.findByUserId");
        namedQuery.setParameter("id", 2);
        Object singleResult = namedQuery.getSingleResult();
        System.out.println(singleResult.toString());
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
//        Department newDepartment1 = new Department();
//        newDepartment1.setName("Finance");
//        em.persist(newDepartment1);

//        ====== Trying to not persist the department and only persist employee (need cascade) =====
//        Department newDepartment2 = new Department();
//        newDepartment2.setName("Research");
//        em.persist(newDepartment2);
//
//        Employee newEmployee3 = new Employee();
//        newEmployee3.setName("Jhiro");
//        newEmployee3.setDepartment(newDepartment2);
//
//        Employee newEmployee4 = new Employee();
//        newEmployee4.setName("Opel");
//        newEmployee4.setDepartment(newDepartment2);
//        em.persist(newEmployee3);
//        em.persist(newEmployee4);
//        ====== Trying to not persist the department and only persist employee =====


//        Employee newEmployee1 = new Employee();
//        newEmployee1.setName("Beta");
//        newEmployee1.setDepartment(newDepartment1);
//

        // ========= INSERT =========
//        Department financeDepartment = em.find(Department.class, 1);
//        Employee newEmployeeNext = new Employee();
//        newEmployeeNext.setName("Rifqi GG");
//        newEmployeeNext.setDepartment(financeDepartment);
        // ========= INSERT =========

//        em.persist(newEmployee1);
//        em.persist(newEmployeeNext);

        // ========= DELETE =========
//        Student student = em.find(Student.class, 403);
//        em.remove(student);

//        Employee employee = em.find(Employee.class, 3);
//        em.remove(employee);

//        Product product = em.find(Product.class, 6);
//        em.remove(product);

        // ========= Find/Retrieve =========
//        Student student = em.find(Student.class, 252);
//        List<Course> courses = student.getCourses();
//        System.out.println("Student id      :" + student.getId());
//        System.out.println("Student name    :" + student.getName());
//        System.out.println("Student course  : ");
//        for (Course courses1 : courses) {
//            System.out.print(courses1.getName() + ", ");
//        }

        transaction.commit();


        // Close Transaction / EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}