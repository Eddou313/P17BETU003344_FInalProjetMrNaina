package models;

public class User{
    private int id;
    private String username;
    private String mdp;

    public User(int id,String username,String mdp){
        this.id = id;
        this.username = username;
        this.mdp = mdp;
    }

    public int getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getMdp(){
        return this.mdp;
    }

}