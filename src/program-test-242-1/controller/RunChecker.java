package controller;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RunChecker {

    private final JButton runButton;
    private final ArrayList<JTextField> textFields;

    public RunChecker(JButton runButton) {
        this.runButton = runButton;
        textFields = new ArrayList<>();
    }
    
    public void checkSettingsForRun() {
        boolean emptyTextField = false;
        
        for(JTextField t : textFields) {
            if (t.getText().equals("")) {
                emptyTextField = true;
            }
        }
        
        if (emptyTextField == true) {
            runButton.setEnabled(false);
        } else {
            runButton.setEnabled(true);
        }
    }
    
    public void trackTextField(JTextField field) {
        textFields.add(field);
    }
}
