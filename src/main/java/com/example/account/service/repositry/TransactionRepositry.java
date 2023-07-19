package com.example.account.service.repositry;

import com.example.account.service.models.Customer;
import com.example.account.service.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositry {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CustomerRepositry customerRepositry;

    public void makeTable(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS transaction (id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, transactedamount BIGINT, status VARCHAR(10), acc BIGINT, FOREIGN KEY (acc) REFERENCES customer(accno))");

    }

    public void createTransaction(Transaction transaction){
        jdbcTemplate.update("INSERT INTO transaction (transactedamount,status,acc)"+"VALUES(?,?,?)" ,
                transaction.getTransactedAmount(),transaction.getStatus(),transaction.getAccNo());
    }

    public void makeCredit(Transaction transaction){
        Customer customer = customerRepositry.findByAccNo(transaction.getAccNo());
        long balance = customer.getCurrentBalance();
        balance += transaction.getTransactedAmount();
       customerRepositry.updateBalance(transaction.getAccNo(),balance);

    }

    public  void makeDebit(Transaction transaction){
        Customer customer = customerRepositry.findByAccNo(transaction.getAccNo());
        long balance = customer.getCurrentBalance();
        balance -= transaction.getTransactedAmount();
        customerRepositry.updateBalance(transaction.getAccNo(),balance);
    }
}
