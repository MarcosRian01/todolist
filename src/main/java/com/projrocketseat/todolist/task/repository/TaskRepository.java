package com.projrocketseat.todolist.task.repository;

import com.projrocketseat.todolist.task.model.TaskModel;
import com.projrocketseat.todolist.user.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    List<TaskModel> findByIdUser(Long User);

}
