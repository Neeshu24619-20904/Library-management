package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.repository.TaskRepository;
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

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasksWithProject() {
        Project p = new Project("P1", "D1");
        Task t1 = new Task("T1", "PENDING", p);
        when(taskRepository.findAllWithProject()).thenReturn(Arrays.asList(t1));

        List<Task> result = taskService.getAllTasksWithProject();
        assertEquals(1, result.size());
        assertEquals("P1", result.get(0).getProject().getName());
        verify(taskRepository, times(1)).findAllWithProject();
    }

    @Test
    void testSaveTask() {
        Task t = new Task("T1", "PENDING", new Project());
        when(taskRepository.save(any(Task.class))).thenReturn(t);

        Task saved = taskService.saveTask(t);
        assertNotNull(saved);
        assertEquals("T1", saved.getTitle());
    }
}
