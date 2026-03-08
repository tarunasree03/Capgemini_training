package com.hiber.CustomerOrderAssessment;

import java.time.LocalDate;

import com.hiber.CustomerOrderAssessment.dao.CustomerDAOImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Question 1
    	
//    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        
//        et.begin();
//        
//        Customer c = new Customer(1, "Ayan", "ayan@gmail.com", "Male", 1234567890, LocalDate.of(2026, 03, 07));
//        
//        Order o = new Order(101, "100", "PlayStation", 1, 50000, LocalDate.of(2026, 03, 07));
//        
//        c.setOrder(o);
//        em.persist(c);
//        
//        et.commit();
    	
    	// Question 2
    	
    	CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//
//        Customer c = new Customer(
//                2,
//                "Anshi",
//                "ansh@gmail.com",
//                "Female",
//                123459876,
//                LocalDate.of(2026, 3, 8)
//        );
//
//        Order o = new Order(
//                102,
//                "201",
//                "Cricket Bat",
//                1,
//                10000,
//                LocalDate.of(2026, 3, 8)
//        );
//
//        // setting relation
//        c.setOrder(o);
//        o.setCustomer(c);
//
//        // CREATE
//        customerDAO.saveCustomer(c);
//
//        // READ
//        Customer customer = customerDAO.getCustomerById(2);
//        System.out.println(customer.getCustomerName());
//
//        // UPDATE
//    	customerDAO.updateCustomerEmail(2, "anshi@gmail.com");
//
//        //DELETE
//        customerDAO.deleteCustomer(1);
    	
    	// Question 3
    	
    	Customer customer = customerDAO.getCustomerByEmail("ayan@gmail.com");

    	System.out.println(customer.getCustomerName());
    }
}
