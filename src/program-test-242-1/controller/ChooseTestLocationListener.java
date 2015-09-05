package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class ChooseTestLocationListener implements ActionListener {

    private final FileController fileController;
    private final ApplicationSettings settings;
    private final JTextField textField;

    public ChooseTestLocationListener(FileController fileController, ApplicationSettings settings, JTextField textField) {
        this.fileController = fileController;
        this.settings = settings;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        settings.setTestCaseDirectory(fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG));
        textField.setText(settings.getTestCaseDirectory().getPath());
    }
}
