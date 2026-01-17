package com.vitor.bookNetwork_api.DTOs;

import jakarta.validation.constraints.NotBlank;

public class BookDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "ISBN is mandatory")
    private String isbn;

    private String category;

    public BookDTO() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }
}
