package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    //Constructor - Initialize EntityManager
    public TaskDAO(){
        // Get EntityManagerFactory from persistence.xml (persistance unit name: "taskPU")

        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }

    // CREATE - Save a new Task to database
    public TaskDTO create(Task task){
        try{
            // Step 1: Begin transaction
            em.getTransaction().begin();

            // Step 2: Persist (save) the Task entity
            em.persist(task);

            //Step 3: Commit transaction (write to database)
            em.getTransaction().commit();

            System.out.println("Task created successfully with id:" + task.getId());

            // Convert Entity to DTO and return
            return convertToDTO(task);
        }
        catch (Exception e){
            // Rollback if error occurs
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            System.out.println("Error creating task:" + e.getMessage());
            return null;
        }
    }

    // Read -Get a task by id
    public TaskDTO read (Long id){
        try {
            // No transaction needed for read operations
            Task task = em.find(Task.class, id);

            if (task != null) {
                System.out.println("Task found with id:" + id);
                return convertToDTO(task);
            } else {
                System.out.println("Task not found with id: " + id);
                return null;
            }
        }catch(Exception e){
            System.out.println("Error reading task:"+ e.getMessage());
            return null;
        }
    }

    public TaskDTO update (Long id, String taskName, String description){
        try{
            // Step 1: Begin transaction
            em.getTransaction().begin();

            // Step 2 : Find the task
            Task task = em.find(Task.class, id);

            if(task != null){
                // Step 3: Update fileds
                task.setTask(taskName);
                task.setDescription(description);

                // Step 4: Merge (update in database)
                Task updatedtask = em.merge(task);

                // Step 5: Commit transaction
                em.getTransaction().commit();

                System.out.println("Task updated successfully with id:" + id);
                return convertToDTO(updatedtask);
            }else{
                em.getTransaction().rollback();
                System.out.println("Task not found with id:"+id);
                return null;
            }
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            System.out.println("Error updating task:" + e.getMessage());
            return null;
        }
    }

    public boolean delete (Long id){
        try{
            // Step 1 : Begin transaction
            em.getTransaction().begin();

            // Step 2: Find the task
            Task task = em.find(Task.class,id);

            if(task != null){
                // Step 3: Remove (delete) from database
                em.remove(task);

                // Step 4: Commit transaction
                em.getTransaction().commit();

                System.out.println("Task deleted sucessfully with id:" + id);
                return true;
            }else {
                em.getTransaction().rollback();
                System.out.println("Task not found with id:" + id);
                return false;
            }
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            System.out.println("Error deleting task: " +e.getMessage());
            return false;
        }
    }

    public List<TaskDTO>getAllTasks(){
        List <TaskDTO> taskList = new ArrayList<>();
        try{
            //JPQL query to get all tasks
            String jpql = "SELECT t FROM Task t";
            List <Task> tasks = em.createQuery(jpql, Task.class).getResultList();

            // Convert each Entity to DTO
            for (Task task:tasks){
                taskList.add(convertToDTO(task));
            }

            System.out.println("Retrived"+ taskList.size()+ "task from database");
            return taskList;
        }catch (Exception e){
            System.out.println("Error retriving tasks:"+ e.getMessage());
            return taskList; // Return empty list if error
        }
    }

    //Helper method -- Convert Entity to DTO
    private TaskDTO convertToDTO(Task task){
        return  new TaskDTO(
            task.getId(),
            task.getTask(),
            task.getDescription()
        );
    }

    // Close EntityManger (cleanup)
    public void close(){
        if(em != null && em.isOpen()){
            em.close();
        }
        if(emf != null && emf.isOpen()){
            emf.close();
        }
        System.out.println("Database connection closed");
    }
}
