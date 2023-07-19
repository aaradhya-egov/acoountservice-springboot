package com.example.account.service.models;

public class Customer {

    private long accNo;
    private String fName;
    private String lName;
    private String mobileNumber;
    private String address;
    private long currentBalance;



    public Customer() {
    }

    public Customer(long accNo, String fname, String lname, String mobilenumber, String address, long currentBalance) {
        this.accNo = accNo;
        this.fName = fname;
        this.lName = lname;
        this.mobileNumber = mobilenumber;
        this.address = address;
        this.currentBalance = currentBalance;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }
}
