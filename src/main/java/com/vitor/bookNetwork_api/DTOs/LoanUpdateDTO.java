package com.vitor.bookNetwork_api.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LoanUpdateDTO {


    @NotNull
    Long userId;

    @NotNull
    Long bookId;

    LocalDate returnDate;

    public LoanUpdateDTO(){}

    public Long getUserId(){
        return userId;
    }

    public Long getBookId(){
        return bookId;
    }

    public LocalDate getReturnDate(){ return returnDate;}
}
