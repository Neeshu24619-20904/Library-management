package com.library_management.library_management.controller;


import com.library_management.library_management.entity.Book;
import com.library_management.library_management.service.AuthorService;
import com.library_management.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooksWithAuthors());
        return "books/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book,
                          @RequestParam Long authorId,
                          RedirectAttributes ra) {
        try {
            book.setAuthor(authorService.getAuthorById(authorId));
            bookService.saveBook(book);
            ra.addFlashAttribute("success", "Book added successfully!");
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error", "Error: duplicate title or invalid data.");
        }
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/form";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute Book book,
                             @RequestParam Long authorId,
                             RedirectAttributes ra) {
        try {
            book.setAuthor(authorService.getAuthorById(authorId));
            bookService.updateBook(id, book);
            ra.addFlashAttribute("success", "Book updated successfully!");
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error", "Error updating book.");
        }
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes ra) {
        bookService.deleteBook(id);
        ra.addFlashAttribute("success", "Book deleted successfully!");
        return "redirect:/books";
    }
}