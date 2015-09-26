package model;

import java.util.Scanner;

public class User {
    private String password;
    private String username;
    
    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }
    
    public static User fromString(String userString) {
        Scanner in = new Scanner(userString);
        
        String username = in.next();
        String password = in.next();
        
        return new User(username, password);
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUsername(String username) {
       this.username = username; 
    }
    
    @Override
    public String toString() {
        return username + " " + password;
    }
}
