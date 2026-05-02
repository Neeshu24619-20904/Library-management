package com.example.projectmanagement.util;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.repository.ProjectRepository;
import com.example.projectmanagement.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProjectRepository projectRepository, TaskRepository taskRepository) {
        return args -> {
            if (projectRepository.count() == 0) {
                List<Project> projects = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    Project p = new Project("Project " + i, "Description for Project " + i);
                    projects.add(projectRepository.save(p));
                }

                for (int i = 1; i <= 10; i++) {
                    Project p = projects.get(i - 1);
                    Task t = new Task("Task " + i, "COMPLETED", p);
                    taskRepository.save(t);
                }
            }
        };
    }
}
