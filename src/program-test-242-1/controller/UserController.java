package controller;

import model.User;

public class UserController {
    
    private User loggedInUser = null;
    
    public UserController() {
        
    }
    
    public boolean validUsername(String username){
        return true;
    }
    
    public boolean validPassword(String password) {
        return true;
    }
    
    public void registerUser(String username, String password) {
    
    }
    
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
