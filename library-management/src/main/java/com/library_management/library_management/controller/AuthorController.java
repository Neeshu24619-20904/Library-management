package com.library_management.library_management.controller;


import com.library_management.library_management.entity.Author;
import com.library_management.library_management.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author, RedirectAttributes ra) {
        try {
            authorService.saveAuthor(author);
            ra.addFlashAttribute("success", "Author added successfully!");
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error", "Error: duplicate or invalid data.");
        }
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "authors/form";
    }

    @PostMapping("/edit/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author, RedirectAttributes ra) {
        try {
            authorService.updateAuthor(id, author);
            ra.addFlashAttribute("success", "Author updated successfully!");
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error", "Error updating author.");
        }
        return "redirect:/authors";
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, RedirectAttributes ra) {
        try {
            authorService.deleteAuthor(id);
            ra.addFlashAttribute("success", "Author deleted successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Error: Cannot delete author with associated books.");
        }
        return "redirect:/authors";
    }
}