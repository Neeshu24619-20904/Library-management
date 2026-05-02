package com.example.projectmanagement.repository;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void testFindAllWithProject() {
        Project p = new Project("Test Project", "Desc");
        projectRepository.save(p);

        Task t = new Task("Test Task", "PENDING", p);
        taskRepository.save(t);

        List<Task> result = taskRepository.findAllWithProject();
        assertFalse(result.isEmpty());
        assertEquals("Test Project", result.get(0).getProject().getName());
    }
}
