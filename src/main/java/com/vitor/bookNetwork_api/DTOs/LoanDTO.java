package com.vitor.bookNetwork_api.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LoanDTO {

    @NotNull
    Long userId;

    @NotNull
    Long bookId;

    public LoanDTO(){}

    public Long getUserId(){
        return userId;
    }

    public Long getBookId(){
        return bookId;
    }

}
