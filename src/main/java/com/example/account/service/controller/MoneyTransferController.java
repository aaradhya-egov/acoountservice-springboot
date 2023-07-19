package com.example.account.service.controller;

import com.example.account.service.repositry.MoneyTransferRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/moneytransfer")
public class MoneyTransferController {

    @Autowired
    private MoneyTransferRepositry moneyTransferRepositry;

    @PostConstruct
    public void makeTable(){
        moneyTransferRepositry.makeTable();
    }


}
