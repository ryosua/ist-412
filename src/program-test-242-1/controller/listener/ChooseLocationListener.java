package controller.listener;

import controller.FileController;
import controller.Main;
import controller.RunChecker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * A class that represents an action listener for a button that opens a file
 * chooser, saves the file picked to settings, and updates a text field.
 *
 */
public abstract class ChooseLocationListener implements ActionListener {

    private final Main main;
    private final JTextField textField;
    private final RunChecker runCheck;

    public ChooseLocationListener(Main main, JTextField textField, RunChecker runCheck) {
        this.main = main;
        this.textField = textField;
        this.runCheck = runCheck;
    }

    public abstract void saveFile(File filePicked);

    public abstract void updateTextField(File filePicked);

    @Override
    public void actionPerformed(ActionEvent e) {
        final File filePicked = main.getFileController().getFileFromChooser(JFileChooser.SAVE_DIALOG);
        if (filePicked != FileController.emptyFile) {
            saveFile(filePicked);
            updateTextField(filePicked);
            runCheck.checkSettingsForRun();
            System.out.println("Checking Settings...");
        }
    }

    public Main getMain() {
        return main;
    }

    public RunChecker getRunCheck() {
        return runCheck;
    }

    public JTextField getTextField() {
        return textField;
    }

}
