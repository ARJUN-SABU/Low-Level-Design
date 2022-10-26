package design_trello;

import java.util.*;
import design_trello.Board;
import design_trello.User;
import design_trello.JobList;

public class BoardManager{
    private HashMap<String, Board> boardMap;

    BoardManager(){
        this.boardMap = new HashMap<>();
    }

    public void createBoard(String name){
        Board board = new Board(name);
        String boardId = board.getId();
        boardMap.put(boardId, board);
        System.out.println("Created board: " + boardId);
    }

    public Board deleteBoard (String id){
        return this.boardMap.remove(id);
    }

    public void showBoard(String id){
        if(!boardMap.containsKey(id)){
            System.out.println("Board " + id + " doesn't exist");
            return;
        }
        System.out.println(boardMap.get(id));
    }

    public void showAllBoards(){
        if(boardMap.size() == 0){
            System.out.println("No boards");
            return;
        }

        System.out.println(boardMap.values());
    }

    public void setName(String id, String name){
        if(!boardMap.containsKey(id)){
            System.out.println("Board " + id + " doesn't exist");
            return;
        }

        boardMap.get(id).setName(name);
    }

    public void setPrivacy(String id, String privacy){
        if(!boardMap.containsKey(id)){
            System.out.println("Board " + id + " doesn't exist");
            return;
        }

        boardMap.get(id).setPrivacy(privacy);
    }


    public void addMember(String id, User user){
        if(!boardMap.containsKey(id)){
            System.out.println("Board " + id + " doesn't exist");
            return;
        }

        boardMap.get(id).addMember(user);
    }

    public void removeMember(String id, User user){
        if(!boardMap.containsKey(id)){
            System.out.println("Board " + id + " doesn't exist");
            return;
        }

        boardMap.get(id).removeMember(user);
    }

    public void addList(String boardId, JobList list){
        this.boardMap.get(boardId).addList(list);
    }
}