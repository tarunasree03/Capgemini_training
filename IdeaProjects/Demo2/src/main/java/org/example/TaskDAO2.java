package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskDAO2 {
    private EntityManagerFactory emf;
    private EntityManager em;

    //Constructor - Initialize EntityManager
    public TaskDAO(){
        // Get EntityManagerFactory from persistence.xml (persistance unit name: "taskPU")

        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }
    public TaskDTO create (Long user_id, Task task){
        try{
            User user = em.find(User.class, user_id);

        }
    }
}
