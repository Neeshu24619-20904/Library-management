package com.library_management.library_management;


import com.library_management.library_management.entity.Author;
import com.library_management.library_management.repository.AuthorRepository;
import com.library_management.library_management.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void testGetAllAuthors() {
        Author author = new Author(1L, "George Orwell", "British", "orwell@test.com", null);
        when(authorRepository.findAll()).thenReturn(List.of(author));
        List<Author> result = authorService.getAllAuthors();
        assertEquals(1, result.size());
        assertEquals("George Orwell", result.get(0).getName());
    }

    @Test
    void testGetAuthorById() {
        Author author = new Author(1L, "George Orwell", "British", "orwell@test.com", null);
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        Author result = authorService.getAuthorById(1L);
        assertNotNull(result);
        assertEquals("George Orwell", result.getName());
    }

    @Test
    void testAuthorNotFound() {
        when(authorRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> authorService.getAuthorById(99L));
    }

    @Test
    void testSaveAuthor() {
        Author author = new Author(null, "New Author", "American", "new@test.com", null);
        when(authorRepository.save(author)).thenReturn(author);
        Author saved = authorService.saveAuthor(author);
        assertNotNull(saved);
        verify(authorRepository, times(1)).save(author);
    }
}
