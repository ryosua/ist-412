package controller.listener;

import controller.Main;
import controller.RunChecker;
import java.io.File;
import javax.swing.JTextField;

public class ChooseSourceLocationListener extends ChooseLocationListener {
  
    public ChooseSourceLocationListener(Main main, JTextField textField, RunChecker runCheck) {
        super(main,textField,runCheck);
    }
    
    @Override
    public void saveFile(File filePicked) {
        getMain().getSettings().setSourceFileDirectory(filePicked);
    }

    @Override
    public void updateTextField(File filePicked) {
        getTextField().setText(getMain().getSettings().getSourceFileDirectory().getPath());
    }
}
