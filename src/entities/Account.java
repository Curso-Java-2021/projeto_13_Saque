package entities;

import exceptions.WithdrawException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return this.holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws WithdrawException {
        if(amount > withdrawLimit){
            throw new WithdrawException("The amount exceeds withdraw limit");
        }
        if(amount > balance){
            throw new WithdrawException("Not enough balance");
        }
        else{
            balance -= amount;
        }
    }

    @Override
    public String toString(){
        return "New balance: " + String.format("%.2f", balance);
    }
}
