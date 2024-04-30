package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        harus membuat entity manager factory untuk jpa
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("belajarJPA");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Begin Transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Product newProduct1 = new Product();
        newProduct1.setName("Sabun");
        newProduct1.setPrice(5000l);
        em.persist(newProduct1);

        transaction.commit();

        // Close Transaction / EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}