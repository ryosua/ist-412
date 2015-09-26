package controller.listener;

import controller.Main;
import controller.UserController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegisterPanel;

public class RegisterUserListener implements ActionListener {
    
    private final Main main;
    private final RegisterPanel panel;
    private final UserController userController;
    
    public RegisterUserListener(Main main, RegisterPanel panel) {
        this.main = main;
        this.panel = panel;
        this.userController = main.getUserController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean success = false;
        success = userController.registerUser(panel.getUserName(), panel.getPassword());
        if (success == false) {
            panel.setMessageLabel("Invalid username or password");
        } else {
            panel.setMessageLabel("User registered");
            panel.clearFields();
        }
    }
    
}
