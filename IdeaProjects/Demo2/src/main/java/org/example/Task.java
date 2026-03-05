package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
// Auto, Identity, sequence ( Postgres, Oracle),
// table (composite key)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;

    @Column(name = "task")
    private String task;

    @Column(name = "description")
    private String description;

    //    Many Tasks belong to One User (ForeignKey)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private User user_id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public User getUser() {
        return user_id;
    }

    public void setUser(User user_id) {
        this.user_id = user_id;
    }





    //    private  int Id;
//    private String task;
//    private String description;
//
//    public int getId(){
//        return Id;
//    }
//
//    public void setId(int id){
//        Id = id;
//    }
//    public String getTask(){
//        return task;
//    }
//    public void setTask(String task){
//        this.task = task;
//    }
//    public String getDescription(){
//        return description;
//    }
//    public void setDescription(String description){
//        this.description = description;
//    }
}
