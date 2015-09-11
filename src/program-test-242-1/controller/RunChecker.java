package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Created by Shane on 9/10/2015.
 */
public class RunChecker {
    private JButton runButton;
    private JTextField sourceField, testField;

    public RunChecker(JButton runButton, JTextField sourceField, JTextField testField){
        this.runButton = runButton;
        this.sourceField = sourceField;
        this.testField = testField;
    }

    public void checkSettingsForRun(){
        if (sourceField.getText().equals("") || testField.getText().equals("")) {
            runButton.setEnabled(false);
        }else {
            runButton.setEnabled(true);
        }
    }
}
