package com.alelekov.bugtracking2.controller;

import com.alelekov.bugtracking2.entities.Project;
import com.alelekov.bugtracking2.entities.Views;
import com.alelekov.bugtracking2.repositories.ProjectRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectRestController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectRestController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Project> list() {
        return projectRepository.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Project getOne(@PathVariable("id") Project project) {
        return project;
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        project.setDateCreate(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @PutMapping("{id}")
    public Project update(@PathVariable("id") Project projectFromDb, @RequestBody Project project) {
        project.setDateUpdate(LocalDateTime.now());
        BeanUtils.copyProperties(project, projectFromDb, "id");
        return projectRepository.save(projectFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Project project) {
        projectRepository.delete(project);
    }
}