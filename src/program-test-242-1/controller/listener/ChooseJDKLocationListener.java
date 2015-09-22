package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JTextField;

public class ChooseJDKLocationListener extends ChooseLocationListener {

    public ChooseJDKLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setJavaVersionDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        // No text to update yet.
    }

}
