package com.alelekov.bugtracking2.controller;

import com.alelekov.bugtracking2.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("project")
public class ProjectRestController {
    private int counter = 4;

    private List<Map<String, String>> projects = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("name", "First project"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("name", "Second project"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("name", "Third project"); }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return projects;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getProject(id);
    }

    private Map<String, String> getProject(@PathVariable String id) {
        return projects.stream()
                .filter(project -> project.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> project) {
        project.put("id", String.valueOf(counter++));

        projects.add(project);

        return project;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> project) {
        Map<String, String> projectFromDb = getProject(id);

        projectFromDb.putAll(project);
        projectFromDb.put("id", id);

        return projectFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> project = getProject(id);

        projects.remove(project);
    }
}