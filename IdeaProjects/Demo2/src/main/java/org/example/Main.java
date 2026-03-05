package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        Task task1 = new Task();
        task1.setTask("Learn Hibernate");
        task1.setDescription("Complete Hibernate tutorial from basics");
        taskDAO.create(task1);

        Task task2 = new Task();
        task2.setTask("Build REST API");
        task2.setDescription("Create REST API with Spring Boot");
        taskDAO.create(task2);

        // Read
        TaskDTO readTask = taskDAO.read(1L);
        System.out.println("Read: " + readTask);

        // Update
        TaskDTO updatedTask = taskDAO.update(1L,
                "Learn Advanced Hibernate",
                "Complete advanced mapping");
        System.out.println("Updated: " + updatedTask);

        // Get All
        List<TaskDTO> allTasks = taskDAO.getAllTasks();
        for (TaskDTO dto : allTasks) {
            System.out.println(dto);
        }

        // Delete
        boolean deleted = taskDAO.delete(2L);
        System.out.println("Deleted: " + deleted);

        taskDAO.close();

//        Task task3 = new Task();
//        task3.setTask("Database Optimization");
//        task3.setDescription("Optimized database queries and index");
//        taskDAO.create(task3);
//
//        System.out.println("\n--- READ: Getting a single task by ID ---");
//        TaskDTO readTask = taskDAO.read(1L);
//        if(readTask != null){
//            System.out.println("Retriveved Task:" + readTask);
//        }
//
//        System.out.println("\n--- LIST: Getting all tasks ---");
//        List<TaskDTO> allTasks = taskDAO.getAllTasks();
//        System.out.println("All tasks in database:");



//        System.out.println("Staring JPA...");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
//        System.out.println("EntityManagerFactory created successfully!");
//        emf.close();
//        System.out.println("Closed successfully!");
    }
}