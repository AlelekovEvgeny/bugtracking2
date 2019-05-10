package com.alelekov.bugtracking2.repositories;

import com.alelekov.bugtracking2.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
