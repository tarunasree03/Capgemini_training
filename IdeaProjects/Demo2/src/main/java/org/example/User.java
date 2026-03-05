package org.example;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // One User can have Many Tasks
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    // Constructors
    public User(){

    }

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + Id +
                "name="+name + '\''+
                ", email='" +email + '\'' +
                ",tasks =" + (tasks != null ? tasks.size() :0) + "tasks" +
                '}';
    }
}
