package design_splitwise;

import java.util.*;
import design_splitwise.Expense;

public class ExpenseExact extends Expense{
    ExpenseExact(String name, String imageURL, String note, double amountPaid){
        super("EXACT", name, imageURL, note, amountPaid);
    }

    public void handleExpense(String userWhoPaid, String[] userIdList, double[] amountList, HashMap<String, HashMap<String, Double>> balanceRecord){
        for(int i = 0; i<userIdList.length; i++){
            settleAmount(userWhoPaid, userIdList[i], amountList[i], balanceRecord);
        }
    }
}
