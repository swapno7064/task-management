package com.root.task_management.service;

import com.root.task_management.exceptions.ResourceNotFoundException;
import com.root.task_management.model.Task;
import com.root.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        return taskRepository.save(task);
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public Task updateTask(String id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setAssignedTo(task.getAssignedTo());
        existingTask.setUpdatedAt(new Date());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    // Add this method to update tasks assigned to a specific user
    public void unassignTasksFromUser(String userId) {
        List<Task> tasks = taskRepository.findByAssignedTo(userId);
        for (Task task : tasks) {
            task.setAssignedTo(null); // Or set to a specific value indicating "not assigned"
            taskRepository.save(task);
        }
    }
}
