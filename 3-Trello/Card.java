package design_trello;

import java.util.*;
import design_trello.User;

public class Card{
    private String cardId;
    private String name;
    private String description;
    private String assignedUser;
    private String listId; //to which list this card belongs.

    Card(String name){
        this.cardId = "card" + UUID.randomUUID().toString();
        this.name = name;
        this.description = "no description";
        this.assignedUser = null;
    }

    public String getId(){
        return this.cardId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void assignUser(String email){
        this.assignedUser = email;
    }

    public void setListId(String listId){
        this.listId = listId;
    }

    public String getListId(){
        return this.listId;
    }

    public String toString(){
        return "{ id: " + this.cardId + ", name: " + this.name + ", description: " + this.description + ", assignedTo: " + this.assignedUser + "}";
    }
}