package com.vitor.bookNetwork_api.services;

import com.vitor.bookNetwork_api.DTOs.LoanDTO;
import com.vitor.bookNetwork_api.DTOs.LoanUpdateDTO;
import com.vitor.bookNetwork_api.models.Book;
import com.vitor.bookNetwork_api.models.Loan;
import com.vitor.bookNetwork_api.models.User;
import com.vitor.bookNetwork_api.repositories.BookRepository;
import com.vitor.bookNetwork_api.repositories.LoanRepository;
import com.vitor.bookNetwork_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Loan createLoan(LoanDTO data){
        Book book = bookRepository.findById(data.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with ID"));

        User user = userRepository.findById(data.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID"));

        if( !book.getAvailable()){
            throw new RuntimeException("The book is already loaded");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Loan newloan = new Loan();
        newloan.setUser(user);
        newloan.setBook(book);
        return loanRepository.save(newloan);
    }

    public List<Loan> listLoan(){
        return loanRepository.findAll();

    }

    public Loan listLoanById(Long id){
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan with ID not found"));
    }

    public Loan updateLoan(Long id, LoanUpdateDTO data){

        Loan loan = loanRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Loan not found with ID"));

        Book book = bookRepository.findById(data.getBookId()).
                orElseThrow(() -> new RuntimeException("Book not found with ID"));

        User user = userRepository.findById(data.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID"));

        if(data.getReturnDate() != null && !data.getReturnDate().isAfter(LocalDate.now())){
            book.setAvailable(true);
        }

        loan.setUser(user);
        loan.setBook(book);
        loan.setReturnDate(data.getReturnDate());

        return  loanRepository.save(loan);

    }

    public void deleteLoan(Long id){
        if(!loanRepository.existsById(id)){
            throw new RuntimeException("Loan not found");
        }
        loanRepository.deleteById(id);
    }


}
