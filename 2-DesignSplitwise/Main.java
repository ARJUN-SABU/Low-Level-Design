import java.util.*;

import design_splitwise.User;
import design_splitwise.BalanceSheet;


public class Main{
    public static void main(String [] args){

        Scanner s = new Scanner(System.in);

        //Number of users and user details can also be taken
        //as a input.
        int numberOfUsers = 4;
        User user1 = new User("u1", "Arjun", "arjun@mail.com", "983989834");
        User user2 = new User("u2", "John", "john@mail.com", "922334434");
        User user3 = new User("u3", "Muhammed", "muhammed@mail.com", "392309342");
        User user4 = new User("u4", "Paji", "paji@mail.com", "33892777932");

        HashMap<String, User> usersMap = new HashMap<>();
        usersMap.put("u1", user1);
        usersMap.put("u2", user2);
        usersMap.put("u3", user3);
        usersMap.put("u4", user4);

        BalanceSheet balanceSheet = new BalanceSheet(numberOfUsers, usersMap);

        
        while(true){
            String [] input = s.nextLine().split(" ");
            if(input[0].equals("SHOW")){
                if(input.length == 1){
                    balanceSheet.showBalance();
                }else{
                    balanceSheet.showBalance(input[1]);
                }
            }else if(input[0].equals("EXPENSE")){
                String userWhoPaid = input[1];
                double amountPaid = Double.parseDouble(input[2]);
                int userCount = Integer.parseInt(input[3]);
                String [] userIdList = new String[userCount];
                int i = 0;
                for(; i<userCount; i++){
                    userIdList[i] = input[3 + i + 1];
                }
                i = 3 + i + 1;
                String expenseType = input[i];
                i++;

                if(expenseType.equals("EQUAL")){
                    String expenseName = input[i++];
                    String imageURL = input[i++];
                    String note = input[i];
                    balanceSheet.expenseEqual(expenseName, imageURL, note, userWhoPaid, amountPaid, userIdList);
                }else if(expenseType.equals("EXACT")){
                    double [] amountList = new double[userCount];
                    for(int j = 0; j<userCount; j++){
                        amountList[j] = Double.parseDouble(input[i++]);
                    }
                    String expenseName = input[i++];
                    String imageURL = input[i++];
                    String note = input[i];
                    balanceSheet.expenseExact(expenseName, imageURL, note, userWhoPaid, amountPaid, userIdList, amountList);
                }else{
                    int [] percentageList = new int[userCount];
                    for(int j = 0; j<userCount; j++){
                        percentageList[j] = Integer.parseInt(input[i++]);
                    }
                    String expenseName = input[i++];
                    String imageURL = input[i++];
                    String note = input[i];
                    balanceSheet.expensePercentage(expenseName, imageURL, note, userWhoPaid,amountPaid, userIdList, percentageList);
                }
            }else{
                System.out.println(usersMap.get(input[1]).getPassbookEntries());
            }
        }
    }
}