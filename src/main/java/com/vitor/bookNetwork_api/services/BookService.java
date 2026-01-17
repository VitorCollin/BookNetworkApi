package com.vitor.bookNetwork_api.services;

import com.vitor.bookNetwork_api.DTOs.BookDTO;
import com.vitor.bookNetwork_api.models.Book;
import com.vitor.bookNetwork_api.repositories.BookRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Book createBook(BookDTO data){
        Book book = modelMapper.map(data, Book.class);

        return bookRepository.save(book);
    }

    public List<Book> listBooks(){

        return bookRepository.findAll();
    }

    public void deleteBook(Long id){
        if(!bookRepository.existsById(id)){
            throw new RuntimeException(("Book Fot Found"));
        }

        bookRepository.deleteById(id);
    }

}
