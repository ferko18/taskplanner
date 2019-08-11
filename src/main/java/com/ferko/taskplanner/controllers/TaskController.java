package com.ferko.taskplanner.controllers;

import com.ferko.taskplanner.models.Task;
import com.ferko.taskplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks",
            produces = {"application/json"})
   public ResponseEntity<?> listAllTasks()
   {
       List <Task> tasks = taskService.findAllTasks();
       return new ResponseEntity<>(tasks, HttpStatus.OK);
   }

    @GetMapping(value = "/expired",
            produces = {"application/json"})
    public ResponseEntity<?> listExpiredTasks()
    {
        List <Task> expiredtasks = taskService.listExpiredTasks();
        return new ResponseEntity<>(expiredtasks, HttpStatus.OK);
    }
   
   @GetMapping(value="/task/{id}", produces = {"application/json"})
   public ResponseEntity<?> findTaskById(@PathVariable Integer id)
   {
       Task task = taskService.findTaskById(id);
       return new ResponseEntity<>(task, HttpStatus.OK);
   }


}