package model;

public class User {
    private String password;
    private String username;
    
    public User(String password, String username) {
        this.password = password;
        this.username = username;
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
}
