package design_trello;

import java.util.*;
import design_trello.User;
import design_trello.JobList;

public class Board{

    private String boardId;
    private String name;
    private String privacy;
    private String url;
    private HashMap <String, User> memberMap;
    private HashMap <String, JobList> listMap;

    Board(String name){
        //UUID -> Universally Unique Identifier
        //this class UUID, is present in util package
        this.boardId = "board" + UUID.randomUUID().toString();
        this.name = name;
        this.privacy = "PUBLIC";
        this.url = "https://www.trelloCopy.com/" + this.boardId;
        this.memberMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    public String getId(){
        return this.boardId;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrivacy(String privacy){
        this.privacy = privacy;
    }

    public void addMember(User user){
        memberMap.put(user.getId(), user);
    }

    public void removeMember(User user){
        if(!memberMap.containsKey(user.getId())){
            System.out.println("User doesn't exist");
            return;
        }
        memberMap.remove(user.getId());
    }

    public void addList(JobList list){
        this.listMap.put(list.getId(), list);
    }

    public String toString(){
        return "{ id: " + this.boardId + ", name: " + this.name + ", privacy: " + this.privacy + ", url: " + this.url + ", lists: " + this.listMap.values() + ", members: " + this.memberMap.values() + "}";
    }

    public Set<String> getListKeys(){
        return this.listMap.keySet();
    }
}