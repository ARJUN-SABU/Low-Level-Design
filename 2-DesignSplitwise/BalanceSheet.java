package design_splitwise;

import java.util.*;
import design_splitwise.User;
import design_splitwise.Expense;
import design_splitwise.ExpenseEqual;
import design_splitwise.ExpenseExact;
import design_splitwise.ExpensePercentage;

public class BalanceSheet{
    private int totalUsers;
    private HashMap<String, HashMap<String, Double>> balanceRecord;
    private HashMap<String, User> usersMap;

    public BalanceSheet(int userCount, HashMap<String, User> usersMap){
        this.totalUsers = userCount;
        this.usersMap = usersMap;
        balanceRecord = new HashMap<>();

        for(int i = 1; i<=userCount; i++){
            balanceRecord.put("u"+i, new HashMap<>());
        }
    }

    //show the balances of every user.
    public void showBalance(){
        boolean balancesPresent = false;

        for(int i = 1; i<=totalUsers; i++){

            HashMap<String, Double> record = balanceRecord.get("u"+i);
            if(record.size() == 0) continue;
            balancesPresent = true;

            for(int j = 1; j<=totalUsers; j++){
                if(i == j) continue;

                if(record.containsKey("u" + j) && record.get("u" + j) > 0.0){
                    System.out.println("User" + i + " owes User" + j + ": " + record.get("u" + j));
                }
            }
        }

        if(!balancesPresent) System.out.println("No balances");
    }


    //shows the balances related to only the given user,
    public void showBalance(String userId){
        //extracting the integer id from user userId
        //eg: for userId = "u10", we extract 10 from it.
        //by splitting the string at "u". So, on the left
        //we get "" (empty string) and on the right of "u"
        //we get "10". So, we get an array ["", "10"] and
        //we tap the 1st index.
        int id = Integer.parseInt(userId.split("u")[1]);

        //how much this user owes to others.
        HashMap<String, Double> userRecord = balanceRecord.get(userId);
        boolean balancePresent = false;

        if(userRecord.size() != 0){
            for(int i = 1; i<=totalUsers; i++){
                if(userRecord.containsKey("u" + i) && userRecord.get("u" + i) > 0.0){
                    balancePresent = true;
                    System.out.println("User" + id + " owes User" + i + ": " + userRecord.get("u" + i));
                }
            }
        }

        //how much others owe to this user
        for(int i = 1; i<=totalUsers; i++){
            if(i == id) continue;
            HashMap<String, Double> record = balanceRecord.get("u" + i);

            if(record.containsKey(userId) && record.get(userId) > 0.0){
                balancePresent = true;
                System.out.println("User" + i + " owes User" + id + ": " + record.get(userId));
            }
        }

        if(!balancePresent) System.out.println("No balances");
    }



    public void expenseEqual(String name, String image, String note, String userWhoPaid, double amountPaid, String [] userIdList){
        ExpenseEqual expenseObject = new ExpenseEqual(name, image, note, amountPaid);
        expenseObject.handleExpense(userWhoPaid, amountPaid, userIdList, balanceRecord);
        usersMap.get(userWhoPaid).updatePassbook(expenseObject.getExpenseDetails());
    }



    public void expenseExact(String name, String image, String note, String userWhoPaid, double amountPaid, String[] userIdList, double[] amountList){
        ExpenseExact expenseObject = new ExpenseExact(name, image, note, amountPaid);
        expenseObject.handleExpense(userWhoPaid, userIdList, amountList, balanceRecord);
        usersMap.get(userWhoPaid).updatePassbook(expenseObject.getExpenseDetails());
    }


    public void expensePercentage(String name, String image, String note, String userWhoPaid, double amountPaid, String[]userIdList, int[]percentageList){
        ExpensePercentage expenseObject = new ExpensePercentage(name, image, note, amountPaid);
        expenseObject.handleExpense(userWhoPaid, amountPaid, userIdList, percentageList, balanceRecord);
        usersMap.get(userWhoPaid).updatePassbook(expenseObject.getExpenseDetails());
    }

}   