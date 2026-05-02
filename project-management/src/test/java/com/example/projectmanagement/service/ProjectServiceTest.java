package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProjects() {
        Project p1 = new Project("P1", "D1");
        Project p2 = new Project("P2", "D2");
        when(projectRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Project> result = projectService.getAllProjects();
        assertEquals(2, result.size());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void testGetProjectById() {
        Project p = new Project("P1", "D1");
        p.setId(1L);
        when(projectRepository.findById(1L)).thenReturn(Optional.of(p));

        Optional<Project> result = projectService.getProjectById(1L);
        assertTrue(result.isPresent());
        assertEquals("P1", result.get().getName());
    }

    @Test
    void testSaveProject() {
        Project p = new Project("P1", "D1");
        when(projectRepository.save(any(Project.class))).thenReturn(p);

        Project saved = projectService.saveProject(p);
        assertNotNull(saved);
        assertEquals("P1", saved.getName());
    }
}
