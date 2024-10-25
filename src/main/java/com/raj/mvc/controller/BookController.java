package com.raj.mvc.controller;

import com.raj.mvc.entity.Book;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> bookList = new ArrayList<>();
    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookList);
        return "books";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book){
        System.out.println("post mapping");
        bookList.add(book);
        return "redirect:/books";
    }

    @GetMapping("/showBook")
    public String showAllAddedBooks(Model model){
        System.out.println("Get Mapping");
        model.addAttribute("book",new Book());
        return "addBook";
    }
}
