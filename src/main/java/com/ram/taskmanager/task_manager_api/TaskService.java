package com.ram.taskmanager.task_manager_api;
import java.util.List;
import java.util.ArrayList;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long nextID = 0;

    public List<Task> getTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        task.setId(nextID);
        nextID++;
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        for(Task task: tasks) {
            if(task.getId().equals(id)) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                return task;
            }
        }
        return null;
    }

    public String deleteTask(Long id) {
        for (Task task: tasks) {
            if(task.getId().equals(id)){
                tasks.remove(task);

                if(tasks.isEmpty()){
                    nextID = 1;
                }
                return "Task delete successfully";
            }
        }
        return "Task not found";
    }
}
