package com.example.account.service.repositry;

import com.example.account.service.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositry {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void makeTable(){
       jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customer (accno BIGINT PRIMARY KEY, fname VARCHAR(20), lname VARCHAR(20), mobilenumber VARCHAR(20), address VARCHAR(30), currentBalance BIGINT)");
    }

    public String saveCustomer(Customer customer){
        jdbcTemplate.update("INSERT INTO customer(accno,fname,lname,mobilenumber,address,currentBalance)" + "VALUES(?,?,?,?,?,?)",
                customer.getAccNo(),customer.getfName(),customer.getlName(),customer.getMobileNumber(),customer.getAddress(),customer.getCurrentBalance());
        return "saved";
    }

    public Customer findByAccNo(long accNo){
        Customer customer= jdbcTemplate.queryForObject("SELECT * FROM customer WHERE accno = ?",new Object[]{accNo}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

    public boolean checkAccExist(long accNo){
        int ans = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer WHERE accno = ?",Integer.class,new Object[]{accNo});
        return ans>0;
    }

    public long getAccBalance(long accNo){
        Customer customer =  jdbcTemplate.queryForObject("SELECT * FROM customer WHERE accno = ?",new Object[]{accNo}, new BeanPropertyRowMapper<>(Customer.class));
        return customer.getCurrentBalance();
    }

    public void updateBalance(long accNo, long balance){
        jdbcTemplate.update("UPDATE customer SET currentBalance = ? WHERE accno=?",balance,accNo);
    }

}
