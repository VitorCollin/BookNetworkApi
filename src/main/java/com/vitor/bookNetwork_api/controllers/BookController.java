package com.vitor.bookNetwork_api.controllers;

import com.vitor.bookNetwork_api.DTOs.BookDTO;
import com.vitor.bookNetwork_api.models.Book;
import com.vitor.bookNetwork_api.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    public BookService bookService;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid BookDTO data){
        Book newBook = bookService.createBook(data);

        return ResponseEntity.ok(newBook);
    }

    @GetMapping
    public List<Book> list(){
        return bookService.listBooks();
    }

    @GetMapping("/{id}")
    public Book listById(@PathVariable Long id){
        return bookService.listBookById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.deleteBook(id);
    }



}
