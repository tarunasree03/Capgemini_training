package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("taskPU");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Start transaction
        em.getTransaction().begin();

        // ----------------------------
        // AUTO Strategy
        // ----------------------------
        TaskAuto autoTask = new TaskAuto();
        autoTask.setTask("Auto Task");
        autoTask.setDescription("Generated using AUTO strategy");
        em.persist(autoTask);

        // ----------------------------
        // IDENTITY Strategy
        // ----------------------------
        TaskIdentity identityTask = new TaskIdentity();
        identityTask.setTask("Identity Task");
        identityTask.setDescription("Generated using IDENTITY strategy");
        em.persist(identityTask);

        // ----------------------------
        // SEQUENCE Strategy
        // ----------------------------
        TaskSequence sequenceTask = new TaskSequence();
        sequenceTask.setTask("Sequence Task");
        sequenceTask.setDescription("Generated using SEQUENCE strategy");
        em.persist(sequenceTask);

        // Commit transaction
        em.getTransaction().commit();

        // Close resources
        em.close();
        emf.close();

        System.out.println("Records inserted successfully!");
    }
}
