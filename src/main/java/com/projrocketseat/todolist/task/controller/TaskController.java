package com.projrocketseat.todolist.task.controller;

import com.projrocketseat.todolist.task.model.TaskModel;
import com.projrocketseat.todolist.task.repository.TaskRepository;
import com.projrocketseat.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((Long) idUser);

        var currentDate = LocalDateTime.now();

        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
            return ResponseEntity.badRequest().body("A data de inicio deve ser maior do que a data atual");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())){
            return ResponseEntity.badRequest().body("A data de inicio deve ser maior do que a data de termino");
        }

        var task = taskRepository.save(taskModel);

        return ResponseEntity.ok(task);
    }

    @GetMapping
    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        return taskRepository.findByIdUser((Long) idUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable Long id){
        var task = taskRepository.findById(id).orElse(null);

        if (task == null){
            return ResponseEntity.badRequest().body("Tarefa não existente!");
        }

        var idUser = request.getAttribute("idUser");

        if (!task.getIdUser().equals(idUser)){
            return ResponseEntity.badRequest().body("Usuário não possui permissão para alterar esta tarefa!");
        }

        Utils.copyNonNullProperties(taskModel, task);
        var taskUpdated = taskRepository.save(task);
        return ResponseEntity.ok(taskUpdated);
    }

}
