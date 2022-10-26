package design_trello;

import java.util.*;
import design_trello.JobList;
import design_trello.Card;

public class ListManager{

    private HashMap <String, JobList> listMap;
    ListManager(){
        listMap = new HashMap<>();
    }

    public JobList createList(String name){
        JobList list = new JobList(name);
        String listId = list.getId();
        listMap.put(listId, list);
        System.out.println("Created List: " + listId);
        return list;
    }

    public JobList removeList(String id){
        return this.listMap.remove(id);
    }

    public void setName(String listId, String name){
        if(!this.listMap.containsKey(listId)){
            System.out.println("List Doesn't Exist!");
            return;
        }
        this.listMap.get(listId).setName(name);
    }

    public void addCard(String listId, Card card){
        this.listMap.get(listId).addCard(card);
    }

    public void removeCard(String listId, String cardId){
        this.listMap.get(listId).removeCard(cardId);
    }

    public void showList(String listId){
        if(!this.listMap.containsKey(listId)){
            System.out.println("List Doesn't Exist!");
            return;
        }

        System.out.println(this.listMap.get(listId));
    }
}