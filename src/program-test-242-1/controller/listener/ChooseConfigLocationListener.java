package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JFileChooser;
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
        //Will throw nullPointer due to MainMenu Lines 37-38.
        getTextField().setText(getMain().getSettings().getConfigFile().getPath());
    }
    
    @Override
    public void setFileType() {
        getMain().getFileController().setFileType(JFileChooser.FILES_ONLY);
    }   
}
