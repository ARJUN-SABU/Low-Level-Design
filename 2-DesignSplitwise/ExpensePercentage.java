package design_splitwise;

import java.util.*;
import design_splitwise.Expense;


public class ExpensePercentage extends Expense{

    ExpensePercentage(String name, String imageURL, String note, double amountPaid){
        super("PERCENTAGE", name, imageURL, note, amountPaid);
    }

    public void handleExpense(String userWhoPaid, double amountPaid, String[]userIdList, int[]percentageList, HashMap<String, HashMap<String, Double>> balanceRecord){
        double amountRemaining = amountPaid;

        for(int i = 0; i<userIdList.length; i++){
            double amountToGive = (percentageList[i] * amountPaid)/100.0;
            amountToGive = Math.round(amountToGive * 100)/100.0;
            amountRemaining -= amountToGive;

            if(userIdList[i].equals(userWhoPaid)) continue;

            if(i == userIdList.length - 1){
                super.settleAmount(userWhoPaid, userIdList[i], amountRemaining, balanceRecord);
            }else{
                super.settleAmount(userWhoPaid, userIdList[i], amountToGive, balanceRecord);
            }
        }
    }
}
