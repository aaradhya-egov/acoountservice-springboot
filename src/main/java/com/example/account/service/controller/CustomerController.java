package com.example.account.service.controller;

import com.example.account.service.models.Customer;
import com.example.account.service.repositry.CustomerRepositry;
import com.example.account.service.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepositry customerRepositry;
    @Autowired
    private customerService customerservice;


    @PostConstruct
    public void makeTable(){
        customerRepositry.makeTable();
    }

    @PostMapping("/createcustomer")
    public String create(@RequestBody Customer customer){
        customer.setAccNo(customerservice.generateRandom());
        return customerRepositry.saveCustomer(customer);
    }
    @PostMapping("/findbyaccno")
    public Customer find(@RequestBody long accNo){
        if(customerRepositry.checkAccExist(accNo)) {
            return customerRepositry.findByAccNo(accNo);
        }
        return null;
    }








}
