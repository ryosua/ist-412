package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

public class RunChecker {
    private final JButton runButton;
    private final JTextField sourceField, testField, outputField;
            
    public RunChecker(JButton runButton, JTextField sourceField, JTextField testField, JTextField outputField){
        this.runButton = runButton;
        this.sourceField = sourceField;
        this.testField = testField;
        this.outputField = outputField;
    }

    public void checkSettingsForRun(){
        if (sourceField.getText().equals("") || testField.getText().equals("") || outputField.getText().equals("")) {
            runButton.setEnabled(false);
        }else {
            runButton.setEnabled(true);
        }
    }
}
