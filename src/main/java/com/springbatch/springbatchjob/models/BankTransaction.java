package com.springbatch.springbatchjob.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String TransactionDate;
    private String Description;
    private String Deposits;
    private String Withdrawls;
    private String Balance;

    public BankTransaction(String transactionDate, String description, String deposits, String withdrawls, String balance) {
        TransactionDate = transactionDate;
        Description = description;
        Deposits = deposits;
        Withdrawls = withdrawls;
        Balance = balance;
    }

    public BankTransaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeposits() {
        return Deposits;
    }

    public void setDeposits(String deposits) {
        Deposits = deposits;
    }

    public String getWithdrawls() {
        return Withdrawls;
    }

    public void setWithdrawls(String withdrawls) {
        Withdrawls = withdrawls;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id=" + id +
                ", TransactionDate='" + TransactionDate + '\'' +
                ", Description='" + Description + '\'' +
                ", Deposits='" + Deposits + '\'' +
                ", Withdrawls='" + Withdrawls + '\'' +
                ", Balance='" + Balance + '\'' +
                '}';
    }
}
