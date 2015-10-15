package view.listener;

import controller.Main;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class ChooseRootLocationListener extends ChooseLocationListener {

    public ChooseRootLocationListener(Main main, JTextField textField) {
        super(main, textField);
    }

    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setRootDirectory(filePicked);
    }

    @Override
    public void setFileType() {
        getMain().getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @Override
    public void updateTextField(File filePicked) {
        getTextField().setText(getMain().getSettings().getRootDirectory().getPath());
    }
    
}
