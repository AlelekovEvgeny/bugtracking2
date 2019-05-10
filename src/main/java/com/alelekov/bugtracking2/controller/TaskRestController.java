package com.alelekov.bugtracking2.controller;

import com.alelekov.bugtracking2.entities.Project;
import com.alelekov.bugtracking2.entities.Task;
import com.alelekov.bugtracking2.entities.Views;
import com.alelekov.bugtracking2.service.TaskService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("task")
public class TaskRestController {
    private final TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @JsonView(Views.FullProject.class)
    public Task create(
            @RequestBody Task task,
            @AuthenticationPrincipal Project project
    ) {
        return taskService.create(task, project);
    }
}