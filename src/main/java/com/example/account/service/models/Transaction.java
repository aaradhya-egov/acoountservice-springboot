package com.example.account.service.models;

public class Transaction {

    private long id;
    private long transactedAmount;
    private String status;
    private long accNo;

    public Transaction() {
    }

    public Transaction(long id, long transactedAmount, String status, long accNo) {
        this.id = id;
        this.transactedAmount = transactedAmount;
        this.status = status;
        this.accNo = accNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransactedAmount() {
        return transactedAmount;
    }

    public void setTransactedAmount(long transactedAmount) {
        this.transactedAmount = transactedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

}
