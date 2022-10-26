import java.util.*;

import design_trello.User;
import design_trello.TrelloDriver;


public class Main{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);

        //create the users or you can take them as
        //input too. But, I am creating the users.
        User user1 = new User("user1", "Arjun", "arjun@mail.com");
        User user2 = new User("user2", "Shivam", "shivam.com");
        User user3 = new User("user3", "Abhishek", "abhishekz@gaming.com");
        User user4 = new User("user4", "SHinchan", "shin@hangama.com");


        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);
        userMap.put(user3.getId(), user4);


        TrelloDriver trello = new TrelloDriver(userMap);


        while(true){
            String [] input = s.nextLine().split(" ");

            if(input[0].equalsIgnoreCase("show")){
                if(input.length == 1){
                    trello.showAll();
                }else if(input[1].equalsIgnoreCase("board")){
                    trello.showBoard(input[2]);
                }else if(input[1].equalsIgnoreCase("list")){
                    trello.showList(input[2]);
                }else if(input[1].equalsIgnoreCase("card")){
                    trello.showCard(input[2]);
                }
            }else if(input[0].equalsIgnoreCase("board")){
                if(input[1].equalsIgnoreCase("create")){
                    trello.createBoard(input[2]);
                }else if(input[1].equalsIgnoreCase("delete")){
                    trello.deleteBoard(input[2]);
                }else{
                    String boardId = input[1];
                    String operation = input[2];

                    if(operation.equalsIgnoreCase("name")){
                        //the name may have spaces 
                        int i = 3;
                        StringBuilder name = new StringBuilder("");
                        for(; i<input.length; i++){
                            name.append(input[i] + " ");
                        }
                        trello.setBoardName(boardId, name.toString());
                    }else if(operation.equalsIgnoreCase("privacy")){
                        trello.setBoardPrivacy(boardId, input[3]);
                    }else if(operation.equalsIgnoreCase("add_member")){
                        trello.addBoardMember(boardId, userMap.get(input[3]));
                    }else if(operation.equalsIgnoreCase("remove_member")){
                        trello.removeBoardMember(boardId, userMap.get(input[3]));
                    }else{
                        System.out.println("Invalid Operation");
                    }
                }
            }else if(input[0].equalsIgnoreCase("list")){
                if(input[1].equalsIgnoreCase("create")){
                    String boardId = input[2];
                     //the name may have spaces 
                    int i = 3;
                    StringBuilder listName = new StringBuilder("");
                    for(; i<input.length; i++){
                        listName.append(input[i] + " ");
                    }
                    trello.createList(boardId, listName.toString());
                }else{
                    String listId = input[1];
                    //this name can have multiple spaces too
                    //but to keep things short i didn't add that feature.
                    //but you can add.
                    String listName = input[3];
                    trello.setListName(listId, listName);
                }
            }else if(input[0].equalsIgnoreCase("card")){
                if(input[1].equalsIgnoreCase("create")){
                    String listId = input[2];
                    String cardName = input[3];
                    trello.createCard(listId, cardName);
                }else{
                    String cardId = input[1];
                    if(input[2].equalsIgnoreCase("name")){
                        //this name can have multiple spaces too
                        //but to keep things short i didn't add that feature.
                        //but you can add.
                        trello.setCardName(cardId, input[3]);
                    }else if(input[2].equalsIgnoreCase("description")){
                        //this description can have multiple spaces too
                        //but to keep things short i didn't add that feature.
                        //but you can add.
                        trello.setCardDescription(cardId, input[3]);
                    }else if (input[2].equalsIgnoreCase("assign")){
                        trello.assignCard(cardId, input[3]);
                    }else if (input[2].equalsIgnoreCase("unassign")){
                        trello.unassignCard(cardId);
                    }else if (input[2].equalsIgnoreCase("move")){
                        String newListId = input[3];
                        trello.moveCard(cardId, newListId);
                    }else{
                        System.out.println("Invalid Input");
                    }
                }
            }else{
                System.out.println("Invalid Inupt");
            }
        }
    }
}