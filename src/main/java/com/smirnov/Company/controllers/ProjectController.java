package com.smirnov.Company.controllers;

import com.smirnov.Company.model.dto.ProjectDto;
import com.smirnov.Company.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProjects() {
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.FOUND);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProject(@PathVariable Integer projectId) {
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addProject(@RequestBody ProjectDto project) {
        return new ResponseEntity<>(String.format("New project Id = %d", projectService.createProject(project)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@RequestBody ProjectDto project) {
        projectService.updateProject(project);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteProject(@PathVariable Integer employeeId) {
        projectService.deleteProject(employeeId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
