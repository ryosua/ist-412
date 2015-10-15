package view.listener;

import view.FileChooser;
import controller.Main;
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

    public ChooseLocationListener(Main main, JTextField textField) {
        this.main = main;
        this.textField = textField;
    }

    public abstract void saveFile(File filePicked);
            
    public abstract void setFileType();

    public abstract void updateTextField(File filePicked);

    @Override
    public void actionPerformed(ActionEvent e) {
        setFileType();
        final File filePicked = main.getFileChooser().getFileFromChooser(JFileChooser.SAVE_DIALOG);
        if (filePicked != FileChooser.emptyFile) {
            saveFile(filePicked);
            updateTextField(filePicked);
            System.out.println(main.getSettings().toString());
        }
    }

    public Main getMain() {
        return main;
    }

    public JTextField getTextField() {
        return textField;
    }

}
