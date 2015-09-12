package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class ChooseSourceLocationListener implements ActionListener {

    private final FileController fileController;
    private final ApplicationSettings settings;
    private final JTextField textField;
    private final RunChecker runCheck;

    public ChooseSourceLocationListener(FileController fileController, ApplicationSettings settings, JTextField textField, RunChecker runCheck) {
        this.fileController = fileController;
        this.settings = settings;
        this.textField = textField;
        this.runCheck = runCheck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        final File filePicked = fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG);
        if (filePicked != FileController.emptyFile) {
            settings.setSourceFileDirectory(filePicked);
            textField.setText(settings.getSourceFileDirectory().getPath());
            runCheck.checkSettingsForRun();
            System.out.println("Checking Settings...");
        }
    }
}
