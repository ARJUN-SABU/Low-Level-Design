package design_trello;

import java.util.*;
import design_trello.Card;

public class JobList{
    private String listId;
    private String name;
    private HashMap <String, Card> cardMap;

    JobList(String name){
        this.listId = "list" + UUID.randomUUID().toString();
        this.name = name;
        this.cardMap = new HashMap<>();
    }

    public String getId(){
        return this.listId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addCard(Card card){
        this.cardMap.put(card.getId(), card);
    }

    public void removeCard(String cardId){
        this.cardMap.remove(cardId);
    }

    public Set<String> getCardKeys(){
        return this.cardMap.keySet();
    }

    public String toString(){
        return "{ id: " + this.listId + ", name: " + this.name + ", cards: " + this.cardMap.values(); 
    }
}
