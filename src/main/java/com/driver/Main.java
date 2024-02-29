package com.driver;

public class Main {
    public static void main(String[] args) {
        String accNo="";
        BankAccount bankAccount = new BankAccount("Amey", 10000, 3000);
        try {
            accNo = bankAccount.generateAccountNumber(4, 9999);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(accNo);
    }
}