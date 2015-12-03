package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.ApplicationSettings;
import view.ChooseStudentsFrame;

public class ChooseStudentsListener implements ActionListener {

    private final ApplicationSettings settings;
    private final JTextField textField;

    private boolean studentWindowOpen = false;

    public ChooseStudentsListener(ApplicationSettings settings, JTextField textField) {
        this.settings = settings;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (studentWindowOpen == false) {
            ChooseStudentsFrame frame = new ChooseStudentsFrame(this, settings);
            frame.initFrame();

            textField.setText("Select students");
        }
    }

    public void setStudentWindowOpen(boolean open) {
        studentWindowOpen = open;
    }

    public JTextField getTextField() {
        return textField;
    }
}
