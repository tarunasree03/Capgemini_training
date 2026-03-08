package com.hiber.CustomerOrderAssessment.dao;


import com.hiber.CustomerOrderAssessment.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OrderDAOImpl {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // CREATE
    public void saveOrder(Order order) {

        et.begin();
        em.persist(order);
        et.commit();

        System.out.println("Order saved successfully");
    }

    // READ
    public Order getOrderById(int id) {

        Order o = em.find(Order.class, id);
        return o;
    }

    // UPDATE
    public void updateOrderPrice(int id, double price) {

        Order o = em.find(Order.class, id);

        if (o != null) {

            et.begin();
            o.setPrice(price);
            em.merge(o);
            et.commit();

            System.out.println("Order updated");
        }
        else {
            System.out.println("Order not found");
        }
    }

    // DELETE
    public void deleteOrder(int id) {

        Order o = em.find(Order.class, id);

        if (o != null) {

            et.begin();
            em.remove(o);
            et.commit();

            System.out.println("Order deleted");
        }
        else {
            System.out.println("Order not found");
        }
    }
}
