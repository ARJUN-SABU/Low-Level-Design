package design_trello;

import java.util.*;
import design_trello.User;
import design_trello.Card;
import design_trello.JobList;
import design_trello.Board;
import design_trello.CardManager;
import design_trello.ListManager;
import design_trello.BoardManager;


public class TrelloDriver {

    HashMap <String, User> usersMap;
    CardManager cardManager;
    ListManager listManager;
    BoardManager boardManager;

    public TrelloDriver(HashMap<String, User> usersMap){
        this.usersMap = usersMap;
        this.cardManager = new CardManager();
        this.listManager = new ListManager();
        this.boardManager = new BoardManager();
    }

    public void showAll(){
        this.boardManager.showAllBoards();
    }
    
    public void showBoard(String id){
        this.boardManager.showBoard(id);
    }
    public void showList(String id){
        this.listManager.showList(id);
    }
    public void showCard(String id){
        this.cardManager.showCard(id);
    }

    public void createBoard(String name){
        this.boardManager.createBoard(name);
    }

    public void deleteBoard(String id){
        //first delete the board
        Board board = this.boardManager.deleteBoard(id);

        //delete all the lists inside the board
        for(String listKey : board.getListKeys()){
            JobList list = listManager.removeList(listKey);

            //delete all the cards inside the list.
            for(String cardKey : list.getCardKeys()){
                cardManager.removeCard(cardKey);
            }
        }

    }

    public void setBoardName(String id, String name){
        this.boardManager.setName(id, name);
    }

    public void setBoardPrivacy(String id, String privacy){
        this.boardManager.setPrivacy(id, privacy);
    }

    public void addBoardMember(String id, User user){
        this.boardManager.addMember(id, user);
    }

    public void removeBoardMember(String id, User user){
        this.boardManager.removeMember(id, user);
    }

    public void createList(String boardId, String listName){
        JobList list = this.listManager.createList(listName);
        this.boardManager.addList(boardId, list);
    }

    public void setListName(String listId, String listName){
        this.listManager.setName(listId, listName);
    }

    public void createCard(String listId, String cardName){
        Card card = this.cardManager.createCard(cardName);
        this.listManager.addCard(listId, card);
        card.setListId(listId);
    }

    public void setCardName(String cardId, String name){
        this.cardManager.setName(cardId, name);
    }

    public void setCardDescription(String cardId, String description){
        this.cardManager.setDescription(cardId, description);
    }

    public void assignCard(String cardId, String email){
        this.cardManager.assignUser(cardId, email);
    }

    public void unassignCard(String cardId){
        this.cardManager.unAssignUser(cardId);
    }

    public void moveCard(String cardId, String newListId){
        Card card = this.cardManager.getCard(cardId);
        String oldListId = card.getListId();
        this.listManager.removeCard(oldListId, cardId);
        card.setListId(newListId);
        this.listManager.addCard(newListId, card);
    }
}








