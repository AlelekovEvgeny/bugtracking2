package com.alelekov.bugtracking2.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@EqualsAndHashCode(of = { "id" })
public class Task {

    @Id
    @GeneratedValue
    @JsonView(Views.IdName.class)
    private Long id;

    @Column(name = "name")
    @JsonView(Views.IdName.class)
    private String nameTask;

    @Column(name = "discription")
    @JsonView(Views.IdName.class)
    private String discriptionTask;

    @Column(name = "priority")
    @JsonView(Views.IdName.class)
    private int priorityTask;

    @Column(name = "date_create", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullProject.class)
    private LocalDateTime dateCreateTask;

    @Column(name = "date_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullProject.class)
    private LocalDateTime dateUpdateTask;

    @Column(name = "status")
    @JsonView(Views.IdName.class)
    private String statusTask;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDiscriptionTask() {
        return discriptionTask;
    }

    public void setDiscriptionTask(String discriptionTask) {
        this.discriptionTask = discriptionTask;
    }

    public int getPriorityTask() {
        return priorityTask;
    }

    public void setPriorityTask(int priorityTask) {
        this.priorityTask = priorityTask;
    }

    public LocalDateTime getDateCreateTask() {
        return dateCreateTask;
    }

    public void setDateCreateTask(LocalDateTime dateCreateTask) {
        this.dateCreateTask = dateCreateTask;
    }

    public LocalDateTime getDateUpdateTask() {
        return dateUpdateTask;
    }

    public void setDateUpdateTask(LocalDateTime dateUpdateTask) {
        this.dateUpdateTask = dateUpdateTask;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(String statusTask) {
        this.statusTask = statusTask;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project proOwner) {
        this.project = proOwner;
    }
}
