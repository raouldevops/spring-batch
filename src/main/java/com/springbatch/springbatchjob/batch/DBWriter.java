package com.springbatch.springbatchjob.batch;

import com.springbatch.springbatchjob.models.BankTransaction;
import com.springbatch.springbatchjob.repository.BankTransactionRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<BankTransaction> {
    @Autowired
    BankTransactionRepository bankTransactionRepository;
    @Override
    public void write(List<? extends BankTransaction> bankTransactions) throws Exception {
        bankTransactionRepository.saveAll(bankTransactions);
        System.out.println("Data saved = "+bankTransactions);
    }
}
