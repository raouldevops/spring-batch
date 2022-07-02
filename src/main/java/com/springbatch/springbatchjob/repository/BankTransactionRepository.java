package com.springbatch.springbatchjob.repository;

import com.springbatch.springbatchjob.models.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction,Integer> {
}
