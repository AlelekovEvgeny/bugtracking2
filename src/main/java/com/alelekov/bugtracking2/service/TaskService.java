package com.alelekov.bugtracking2.service;

import com.alelekov.bugtracking2.entities.Project;
import com.alelekov.bugtracking2.entities.Task;
import com.alelekov.bugtracking2.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task, Project project) {
        task.setProject(project);
        taskRepository.save(task);

        return task;
    }
}
