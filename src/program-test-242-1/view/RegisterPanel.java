package view;

import controller.Main;
import view.listener.RegisterUserListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {
    
    private final Main main;
    
    private JTextField passwordField;
    private JTextField usernameField;
    
    public RegisterPanel(Main main) {
        this.main = main;

        createAndAddComponents();
    }
    
    public String getPassword() {
        return passwordField.getText();
    }
    
    public String getUserName() {
        return usernameField.getText();
    }

    private void createAndAddComponents() {
        final GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        final JLabel usernameLabel = new JLabel("Username:");
        final GridBagConstraints usernameLabelC = new GridBagConstraints();
        usernameLabelC.fill = GridBagConstraints.HORIZONTAL;
        usernameLabelC.gridx = 0;
        usernameLabelC.gridy = 0;

        final JLabel passwordLabel = new JLabel("Password:");
        final GridBagConstraints passwordLabelC = new GridBagConstraints();
        passwordLabelC.fill = GridBagConstraints.HORIZONTAL;
        passwordLabelC.gridx = 0;
        passwordLabelC.gridy = 2;

        usernameField = new JTextField();
        final GridBagConstraints usernameFieldC = new GridBagConstraints();
        usernameFieldC.fill = GridBagConstraints.HORIZONTAL;
        usernameFieldC.gridx = 0;
        usernameFieldC.gridy = 1;

        passwordField = new JTextField();
        final GridBagConstraints passwordFieldC = new GridBagConstraints();
        passwordFieldC.fill = GridBagConstraints.HORIZONTAL;
        passwordFieldC.gridx = 0;
        passwordFieldC.gridy = 3;

        final JButton registerButton = new JButton("Register");
        final GridBagConstraints registerButtonC = new GridBagConstraints();
        registerButtonC.fill = GridBagConstraints.HORIZONTAL;
        registerButtonC.gridx = 0;
        registerButtonC.gridy = 4;
        registerButton.addActionListener(new RegisterUserListener(main, this));

        add(usernameLabel, usernameLabelC);
        add(passwordLabel, passwordLabelC);
        add(usernameField, usernameFieldC);
        add(passwordField, passwordFieldC);
        add(registerButton, registerButtonC);
    }
}
