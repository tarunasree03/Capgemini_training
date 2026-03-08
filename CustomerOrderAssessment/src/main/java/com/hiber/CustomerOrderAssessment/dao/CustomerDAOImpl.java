package com.hiber.CustomerOrderAssessment.dao;


import com.hiber.CustomerOrderAssessment.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerDAOImpl {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // CREATE
    public void saveCustomer(Customer customer) {

        et.begin();
        em.persist(customer);
        et.commit();

        System.out.println("Customer saved successfully");
    }

    // READ
    public Customer getCustomerById(int id) {

        Customer c = em.find(Customer.class, id);
        return c;
    }

    // UPDATE
    public void updateCustomerEmail(int id, String newEmail) {

        Customer c = em.find(Customer.class, id);

        if (c != null) {

            et.begin();
            c.setEmail(newEmail);
            em.merge(c);
            et.commit();

            System.out.println("Customer updated");
        }
        else {
            System.out.println("Customer not found");
        }
    }

    // DELETE
    public void deleteCustomer(int id) {

        Customer c = em.find(Customer.class, id);

        if (c != null) {

            et.begin();
            em.remove(c);
            et.commit();

            System.out.println("Customer deleted");
        }
        else {
            System.out.println("Customer not found");
        }
    }
    
    
    public Customer getCustomerByEmail(String email) {

        String jpql = "SELECT c FROM Customer c WHERE c.email = :email";

        Customer customer = em.createQuery(jpql, Customer.class)
                .setParameter("email", email)
                .getSingleResult();

        return customer;
    }
}
