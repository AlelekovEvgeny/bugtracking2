package com.alelekov.bugtracking2.repositories;

import com.alelekov.bugtracking2.entities.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @EntityGraph(attributePaths = { "tasks" })
    List<Project> findAll();
}
