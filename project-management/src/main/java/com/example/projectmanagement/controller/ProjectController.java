package com.example.projectmanagement.controller;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "project-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project project) {
        try {
            projectService.saveProject(project);
        } catch (Exception e) {
            // Basic exception handling for integrity violations
            return "redirect:/projects/add?error=integrity_violation";
        }
        return "redirect:/projects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        model.addAttribute("project", project);
        return "project-form";
    }

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") Long id, @ModelAttribute("project") Project project) {
        try {
            projectService.updateProject(id, project);
        } catch (Exception e) {
            return "redirect:/projects/edit/" + id + "?error=integrity_violation";
        }
        return "redirect:/projects";
    }
}
