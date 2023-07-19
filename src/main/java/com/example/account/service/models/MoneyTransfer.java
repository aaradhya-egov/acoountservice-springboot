package com.example.account.service.models;

public class MoneyTransfer {
    private long id;
    private long fromAccNo;
    private long toAccNo;

    public MoneyTransfer() {

    }

    public MoneyTransfer(long id, long fromAccNo, long toAccNo) {
        this.id = id;
        this.fromAccNo = fromAccNo;
        this.toAccNo = toAccNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromAccNo() {
        return fromAccNo;
    }

    public void setFromAccNo(long fromAccNo) {
        this.fromAccNo = fromAccNo;
    }

    public long getToAccNo() {
        return toAccNo;
    }

    public void setToAccNo(long toAccNo) {
        this.toAccNo = toAccNo;
    }
}
