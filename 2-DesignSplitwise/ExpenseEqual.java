package design_splitwise;

import java.util.*;
import design_splitwise.Expense;


public class ExpenseEqual extends Expense{

    ExpenseEqual(String name, String imageURL, String note, double amountPaid){
        super("EQUAL", name, imageURL, note, amountPaid);
    }

    public void handleExpense(String userWhoPaid, double amountPaid, String [] userIdList, HashMap<String, HashMap<String, Double>> balanceRecord){
        int usersConsidered = userIdList.length;

        //say user 1 paid 1000 for 6 users including user 1 so, 1000/6 = 166.666666....
        //we round it off to 2 decimal places = 166.67. How is this working?
        //so, 1000/6 = 166.666666. Say x = 166.66666....
        //now, x*100 = 16666.6666.... (see the decimal shifted rightwards by 2 steps)
        //now, x = Math.round(x) = 16667 as Math.round() rounds it off to the 
        //nearest decima. => x = 16667
        //and, x/100.0 = 166.67.
        double amountToGive = Math.round(((double)amountPaid/usersConsidered)*100)/100.0;

        for(int i = 0; i<usersConsidered; i++){
            
            //0th user is the one who paid the amount
            //for everyone. So skip that user.
            if(userIdList[i].equals(userWhoPaid)){
                amountPaid -= amountToGive;
                continue;
            }

            if(i == usersConsidered-1){
                //if it is the last user.
                //say user 1 paid 1000 for 6 users including user 1
                //so, 1000/6 = 166.666666....
                //we round it off to 2 decimal places = 166.67.
                //so, user1, user2, user3, user4, user5 pay 166.67
                //and we kept on subtracting that amount from amountPaid
                //that is, 1000 - (166.67*5) = 166.65.
                //and then for the last user, the amountPaid left is
                //166.65. So, the last user pays 166.65. So, for him
                //amountToGive = amountPaid, i.e, 166.65 and not 166.67
                super.settleAmount(userWhoPaid, userIdList[i], amountPaid, balanceRecord);
            }else{
                super.settleAmount(userWhoPaid, userIdList[i], amountToGive, balanceRecord);
                amountPaid -= amountToGive;
            }
        }

    }
}
