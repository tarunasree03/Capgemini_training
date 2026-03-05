package org.example;

public class TaskDTO {
    private int id;
    private String  task;
    private  String description;
    private Long user_id;

    // Default constructor
    public TaskDTO(){

    }

    // Constructor with all fields
    public TaskDTO (int id, String task, String description, Long user_id){
        this.id = id;
        this.task = task;
        this.description = description;
        this.user_id = user_id;

    }

    // Getter & Setter
    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getTask(){
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description =description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString(){
        return "TaskDTO{" +
                "id=" + id +
                ", task=" +task + '\'' +
                ", description ='" + description + '\'' +
                "user_id= " + user_id + "}";
    }

}
