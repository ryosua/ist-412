package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ChooseStudentsListener  implements ActionListener {
    
    private final JTextField textField;
    
    public ChooseStudentsListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open Choose Students Panel here.");
        textField.setText("# students selected");
    }
  
}
