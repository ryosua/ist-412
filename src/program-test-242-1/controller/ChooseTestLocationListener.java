package controller;

import java.io.File;
import javax.swing.JTextField;

public class ChooseTestLocationListener extends ChooseLocationListener {

    public ChooseTestLocationListener(Main main, JTextField textField, RunChecker runCheck) {
        super(main, textField, runCheck);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setTestCaseDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        getTextField().setText(getMain().getSettings().getTestCaseDirectory().getPath());
    }
}
