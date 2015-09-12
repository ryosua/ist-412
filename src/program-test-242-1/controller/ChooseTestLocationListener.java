package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class ChooseTestLocationListener implements ActionListener {
    
    private final Main main;
    private final JTextField textField;
    private final RunChecker runCheck;

    public ChooseTestLocationListener(Main main, JTextField textField, RunChecker runCheck) {
        this.main = main;
        this.textField = textField;
        this.runCheck = runCheck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final File filePicked = main.getFileController().getFileFromChooser(JFileChooser.SAVE_DIALOG);
        if (filePicked != FileController.emptyFile) {
            main.getSettings().setTestCaseDirectory(filePicked);
            textField.setText(main.getSettings().getTestCaseDirectory().getPath());
            runCheck.checkSettingsForRun();
            System.out.println("Checking Settings...");
        }
    }
}
