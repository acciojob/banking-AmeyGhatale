package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }


    public String generateAccountNumber(int digits, int sum) throws java.lang.Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder ans = new StringBuilder();
        while (digits>0){
            if(sum>=9){
                ans.append(9);
                sum -= 9;
                digits--;
            }
            else {
                int x = sum;
                sum -= x;
                ans.append(x);
                digits--;
//                break;
            }
        }

        if(sum!=0)
            throw new Exception("Account Number can not be generated");

        return ans.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws java.lang.Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double sum = this.balance - amount;

        if (sum<minBalance)
            throw new Exception("Maximum Withdraw Limit Exceed");
        if(sum<0)
            throw new Exception("Insufficient Balance" );

        this.balance = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}