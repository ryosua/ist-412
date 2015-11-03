package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.ApplicationSettings;

public class StudentsPanel extends JPanel {
    
    private final JFrame frame;
    private final ApplicationSettings settings;

    public StudentsPanel(StudentsFrame frame, ApplicationSettings settings) {
        this.frame = frame;
        this.settings = settings;
    }
    
}
