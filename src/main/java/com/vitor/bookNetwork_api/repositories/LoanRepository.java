package com.vitor.bookNetwork_api.repositories;

import com.vitor.bookNetwork_api.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
