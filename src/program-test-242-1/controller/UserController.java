package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApplicationSettings;
import model.User;

public class UserController {
    
    private User loggedInUser = null;
    private final ArrayList<User> users;
    private final File usersFile = new File("users.txt");
    
    public UserController() {
        users = readUsersFromFile();
    }
    
    public void printUsers() {
        System.out.println("Users: ");
        for(User user: users) {
            System.out.println(user);
        }
    }
    
    public ArrayList<User> readUsersFromFile() {
        ArrayList<User> usersFromFile = new ArrayList<>();
        Scanner in = null;
        try {
            usersFile.createNewFile();
            
            in = new Scanner(usersFile);

            while(in.hasNextLine()){
                usersFromFile.add(User.fromString(in.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationSettings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            in.close();
        }
        return usersFromFile;
    }
    
    public boolean registerUser(String username, String password) {
        boolean success = false;
        if (validUsername(username) && validPassword(password)) {
            User user = new User(username, password);
            users.add(user);
            writeUsersToFile();
            success = true;
        }
        printUsers();
        return success;
    }
    
    public boolean validUsername(String username){
        return true;
    }
    
    public boolean validPassword(String password) {
        boolean valid = false;
       
        // Check the password length.
        if ((password.length() >= 10) && (password.length() <= 20)) {
            valid = true;
        }
        
        return valid;
    }
    
    public void writeUsersToFile() {
        System.out.println("Writing users to file.");
        PrintWriter out = null;
        try {
            usersFile.createNewFile();
            out = new PrintWriter(usersFile);
            for(User user: users) {
                out.println(user);
                System.out.println("print user");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            out.close();
        }
    }
     
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
