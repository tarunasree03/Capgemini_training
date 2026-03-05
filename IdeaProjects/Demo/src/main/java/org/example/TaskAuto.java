package org.example;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "task_auto")
public class TaskAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String task;
    private String description;

    // Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
