package com.projrocketseat.todolist.task.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Task")
@Table(name = "tb_task")
@Data
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Column(length = 50)
    private String title;
    @Column(name = "start_at")
    private LocalDateTime startAt;
    @Column(name = "end_at")
    private LocalDateTime endAt;
    private String priority;

    @Column(name = "id_user")
    private Long idUser;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /*public void setTitle(String title) throws Exception {
        if (title.length() > 50){
            throw new Exception("O campo title deve conter no maximo 50 caracteres");
        }
        this.title = title;
    }*/

}
