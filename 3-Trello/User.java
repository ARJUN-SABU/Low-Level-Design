package design_trello;

public class User{
    private String userId;
    private String name;
    private String email;

    public User(String id, String name, String email){
        this.userId = id;
        this.name = name;
        this.email = email;
    }

    public String getId(){
        return this.userId;
    }

    public String toString(){
        return "{ id: " + this.userId + ", name: " + this.name + ", email: " + this.email + "}"; 
    }
}