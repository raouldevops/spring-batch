package com.springbatch.springbatchjob.batch;

import com.springbatch.springbatchjob.models.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class Processor implements ItemProcessor<BankTransaction,BankTransaction> {
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date newDate=formatter.parse(bankTransaction.getTransactionDate());
        String formattedDate = formatter.format(newDate);

        SimpleDateFormat formatterToSql=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String formattedDateString = formatterToSql.format(newDate);

        bankTransaction.setTransactionDate(formattedDateString);
        System.out.println(String.format("Converted from [%s] to [%s] ",formattedDate,formattedDateString));
        return bankTransaction;
    }
}
