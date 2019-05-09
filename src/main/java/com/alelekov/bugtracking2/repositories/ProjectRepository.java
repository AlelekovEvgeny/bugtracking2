package com.alelekov.bugtracking2.repositories;

import com.alelekov.bugtracking2.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
