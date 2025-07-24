package com.example.tasks.Controller;

import com.example.tasks.Entity.Task;
import com.example.tasks.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("add")
    public Task addTask(Task task){
        return taskService.addTask(task);
    }

    @PatchMapping("patch")
    public Task updateTask(long id, Task newTask){
        return taskService.updateTask(id, newTask);
    }

    @DeleteMapping("delete")
    public void deleteTask(long id){
        taskService.deleteTask(id);
    }
}
