package com.ram.taskmanager.task_manager_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService = new TaskService();
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
}
