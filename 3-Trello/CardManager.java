package design_trello;

import java.util.*;
import design_trello.Card;

public class CardManager{

    private HashMap<String, Card> cardMap;

    CardManager(){
        cardMap = new HashMap<>();
    }

    public Card createCard(String name){
        Card card = new Card(name);
        String cardId = card.getId();
        cardMap.put(cardId, card);
        System.out.println("Created card: " + cardId);
        return card;
    }

    public void setName(String cardId, String name){
        if(!this.cardMap.containsKey(cardId)){
            System.out.println("Card doesn't exist");
            return;
        }
        this.cardMap.get(cardId).setName(name);
    }

    public void setDescription(String cardId, String description){
        if(!this.cardMap.containsKey(cardId)){
            System.out.println("Card doesn't exist");
            return;
        }
        this.cardMap.get(cardId).setDescription(description);
    }

    public void assignUser(String cardId, String email){
        if(!this.cardMap.containsKey(cardId)){
            System.out.println("Card doesn't exist");
            return;
        }
        this.cardMap.get(cardId).assignUser(email);
    }

    public void unAssignUser(String cardId){
        if(!this.cardMap.containsKey(cardId)){
            System.out.println("Card doesn't exist");
            return;
        }
        this.cardMap.get(cardId).assignUser(null);
    }

    public void showCard(String cardId){
        if(!this.cardMap.containsKey(cardId)){
            System.out.println("Card doesn't exist");
            return;
        }
        System.out.println(this.cardMap.get(cardId));
    }

    public Card removeCard(String id){
        return this.cardMap.remove(id);
    }

    public Card getCard(String id){
        return this.cardMap.get(id);
    }
}