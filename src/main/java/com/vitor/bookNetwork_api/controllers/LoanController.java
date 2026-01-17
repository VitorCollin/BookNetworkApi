package com.vitor.bookNetwork_api.controllers;

import com.vitor.bookNetwork_api.DTOs.LoanDTO;
import com.vitor.bookNetwork_api.models.Loan;
import com.vitor.bookNetwork_api.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    private ResponseEntity<Loan> create(@RequestBody @Valid LoanDTO data){
        Loan newLoan = loanService.createLoan(data);
        return ResponseEntity.ok(newLoan);
    }

    @GetMapping
    private List<Loan> list (){
        return loanService.listLoan();
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id){
        loanService.deleteLoan(id);
    }

}
