package design_splitwise;

import java.util.*;

public class Expense {
    private String expenseType;
    private String name;
    private String image;
    private String note;
    private double amountPaid;

    public Expense(String expenseType, String name, String imageURL, String note, double amountPaid){
        this.expenseType = expenseType;
        this.name = name;
        this.image = imageURL;
        this.note = note;
        this.amountPaid = amountPaid;
    }

    public String getExpenseDetails(){
        return "  {" + "\n\ttype: " + this.expenseType + ",\n\tname: " + this.name + ",\n\timage url: " + this.image + ",\n\tnote: " + this.note + ",\n\tamount paid: " + this.amountPaid + "\n  }";
    } 

    public void settleAmount(String user1, String user2, double amountToGive, HashMap<String, HashMap<String, Double>> balanceRecord){
        //using shorter naming conventions
        //userWhoPaid -> A
        //userIdList[i] -> B
        //So, B owes A 'amountToGive' amount

        String A = user1;
        String B = user2;

        //amount which B owes A
        double amountBtoA = balanceRecord.get(B).containsKey(A) ? balanceRecord.get(B).get(A) : 0;
        amountBtoA += amountToGive;

        //amount which A owes B
        double amountAtoB = balanceRecord.get(A).containsKey(B) ? balanceRecord.get(A).get(B) : 0;

        //So, for user A,
        //amountBtoA is incoming, so we kept it +ve.
        //amountAtoB is outgoing, so we kept it -ve.
        double finalAmount = amountBtoA - amountAtoB;

        if(finalAmount > 0){
            //since net final amount is +ve,
            //therefore, net final amount is incoming
            //to user A. So that net final amount
            //is given by B to A. And net-net B owes A
            //finalAmount and A owes B 0.0.
            balanceRecord.get(A).put(B,0.0);
            balanceRecord.get(B).put(A, finalAmount);
        }else if(finalAmount < 0){
            //if net FinalAmount is -ve, that means
            //finalAmount is outgoing.
            //A owes finalAmount to B and B owes 0.0 to A
            balanceRecord.get(A).put(B, finalAmount);
            balanceRecord.get(B).put(A, 0.0);
        }else{
            //if net finalAmount is 0.0. That means,
            //everything is settled between A and B
            //and no one owes anything to anyone.
            balanceRecord.get(A).put(B, 0.0);
            balanceRecord.get(B).put(A, 0.0);
        }
    }
}
