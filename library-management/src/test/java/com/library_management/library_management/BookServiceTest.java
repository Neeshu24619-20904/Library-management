package com.library_management.library_management;

import com.library_management.library_management.entity.Author;
import com.library_management.library_management.entity.Book;
import com.library_management.library_management.repository.BookRepository;
import com.library_management.library_management.service.BookService;
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
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGetAllBooks() {
        Author author = new Author(1L, "Test Author", "British", "test@test.com", null);
        Book book = new Book(1L, "Test Book", "Fiction", 2020, author);
        when(bookRepository.findAll()).thenReturn(List.of(book));
        List<Book> result = bookService.getAllBooks();
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
    }

    @Test
    void testGetBookById() {
        Book book = new Book(1L, "Test Book", "Fiction", 2020, null);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book result = bookService.getBookById(1L);
        assertNotNull(result);
        assertEquals("Test Book", result.getTitle());
    }

    @Test
    void testGetBookByIdNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.getBookById(99L));
    }

    @Test
    void testSaveBook() {
        Book book = new Book(null, "New Book", "Drama", 2023, null);
        when(bookRepository.save(book)).thenReturn(book);
        Book saved = bookService.saveBook(book);
        assertNotNull(saved);
        verify(bookRepository, times(1)).save(book);
    }
}