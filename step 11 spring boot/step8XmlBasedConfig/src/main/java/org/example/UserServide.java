package org.example;

public class UserServide {

    private String name;

    public UserServide(String name){
        this.name = name;
        System.out.println("UserService created");
    }

    public String getName(){
        return  name;
    }

    public void init(){
        System.out.println("Post construct phase");
    }

    public void cleanup(){
        System.out.println("Pre construct pahse");
    }

}
