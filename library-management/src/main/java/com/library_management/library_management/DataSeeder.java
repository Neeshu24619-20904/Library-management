package com.library_management.library_management;


import com.library_management.library_management.entity.Author;
import com.library_management.library_management.entity.Book;
import com.library_management.library_management.repository.AuthorRepository;
import com.library_management.library_management.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


@Configuration
public class DataSeeder {


    @Bean
    CommandLineRunner seedData(AuthorRepository authorRepo, BookRepository bookRepo) {
        return args -> {
            if (authorRepo.count() == 0) {
                Author a1 = authorRepo.save(new Author(null, "George Orwell", "British", "orwell@books.com", null));
                Author a2 = authorRepo.save(new Author(null, "J.K. Rowling", "British", "rowling@books.com", null));
                Author a3 = authorRepo.save(new Author(null, "F. Scott Fitzgerald", "American", "fitzgerald@books.com", null));
                Author a4 = authorRepo.save(new Author(null, "Harper Lee", "American", "lee@books.com", null));
                Author a5 = authorRepo.save(new Author(null, "Gabriel Garcia Marquez", "Colombian", "marquez@books.com", null));
                Author a6 = authorRepo.save(new Author(null, "Fyodor Dostoevsky", "Russian", "dostoevsky@books.com", null));
                Author a7 = authorRepo.save(new Author(null, "Jane Austen", "British", "austen@books.com", null));
                Author a8 = authorRepo.save(new Author(null, "Ernest Hemingway", "American", "hemingway@books.com", null));
                Author a9 = authorRepo.save(new Author(null, "Toni Morrison", "American", "morrison@books.com", null));
                Author a10 = authorRepo.save(new Author(null, "Leo Tolstoy", "Russian", "tolstoy@books.com", null));

                bookRepo.saveAll(List.of(
                        new Book(null, "1984", "Dystopian", 1949, a1),
                        new Book(null, "Harry Potter and the Sorcerers Stone", "Fantasy", 1997, a2),
                        new Book(null, "The Great Gatsby", "Classic", 1925, a3),
                        new Book(null, "To Kill a Mockingbird", "Classic", 1960, a4),
                        new Book(null, "One Hundred Years of Solitude", "Magical Realism", 1967, a5),
                        new Book(null, "Crime and Punishment", "Psychological Fiction", 1866, a6),
                        new Book(null, "Pride and Prejudice", "Romance", 1813, a7),
                        new Book(null, "The Old Man and the Sea", "Literary Fiction", 1952, a8),
                        new Book(null, "Beloved", "Historical Fiction", 1987, a9),
                        new Book(null, "War and Peace", "Historical Fiction", 1869, a10)
                ));
            }
        };
    }
}
