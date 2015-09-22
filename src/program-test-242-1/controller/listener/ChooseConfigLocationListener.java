package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JTextField;

public class ChooseConfigLocationListener extends ChooseLocationListener {

    public ChooseConfigLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setConfigFile(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        // No text to update yet.
    }
    
}
