package com.example.account.service.controller;

import com.example.account.service.models.Customer;
import com.example.account.service.models.Transaction;
import com.example.account.service.repositry.CustomerRepositry;
import com.example.account.service.repositry.TransactionRepositry;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepositry tranasactionRepositry;
    @Autowired
    private CustomerRepositry customerRepositry;

    @PostConstruct
    public void makeTable(){
        tranasactionRepositry.makeTable();
    }

//    @PostMapping("qw")
//    public void cr(@RequestBody Transaction transaction){
//        tranasactionRepositry.createTransaction(transaction);
//    }

    @PostMapping("dotransaction")
    public String transaction(@RequestBody Transaction transaction){

        if(customerRepositry.checkAccExist(transaction.getAccNo())) {
            tranasactionRepositry.createTransaction(transaction);
            String x = transaction.getStatus();

            if(x.equals("credit")){
                tranasactionRepositry.makeCredit(transaction);
            }
            else{
                if(customerRepositry.getAccBalance(transaction.getAccNo())>=transaction.getTransactedAmount()){
                    tranasactionRepositry.makeDebit(transaction);
                }
                else{
                    return "insufficent balance";
                }
            }
        }

        return "transacted";
   }

}
