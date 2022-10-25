package design_splitwise;

import java.util.*;

public class User{
    private String userId;
    private String name;
    private String email;
    private String mobileNumber;
    private ArrayList<String> passbook;

    public User(String uId, String name, String email, String mobileNumber){
        this.userId = uId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.passbook = new ArrayList<>();
    }

    public void updatePassbook(String transactionDetails){
        passbook.add(transactionDetails);
    }

    public String getPassbookEntries(){
        StringBuilder sb = new StringBuilder("");
        sb.append("[\n");
        for(String transaction : passbook){
            sb.append(transaction + ",\n");
        }
        sb.append("]\n");
        return sb.toString();
    }
}