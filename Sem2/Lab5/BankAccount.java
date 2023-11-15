package com.pjatk.bank;

public class BankAccount {
    public String accountNumber;
    public double currentMoney;


    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    double getCurrentMoney(){
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney){
        this.currentMoney = currentMoney;
    }
}
