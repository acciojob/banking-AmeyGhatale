package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;

        if(balance<5000)
            throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        HashMap<Character,Integer>mp=new HashMap<>();

        int n=tradeLicenseId.length()/2;

        for(Character ch:tradeLicenseId.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(Character c:mp.keySet()){
            if(mp.get(c)>n){
                throw new Exception("Valid License can not be");
            }
        }

//        if (!validatingLicense(tradeLicenseId))
//            throw new Exception("Valid License can not be generated");

    }

    public boolean validatingLicense(String id){
        HashMap<Character, Integer> license = new HashMap<>();
        int n = id.length()/2;

        for(Character ch : id.toCharArray()){
            license.put(ch, license.getOrDefault(ch, 0)+1);
        }

        for(Character ch : license.keySet()){
            if(license.get(ch) > n)
                return false;
        }
        return true;
    }


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}
