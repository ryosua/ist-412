package controller.listener;

import controller.Main;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class ChooseOutputLocationListener extends ChooseLocationListener {

    public ChooseOutputLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setOutputFileDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        getTextField().setText(getMain().getSettings().getOutputFileDirectory().getPath());
    }
    
    @Override
    public void setFileType() {
        getMain().getFileController().setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
}
