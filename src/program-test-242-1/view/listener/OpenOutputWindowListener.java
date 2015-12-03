package view.listener;

import view.TrivialEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationSettings;
import model.Student;
import view.OutputPanel;

public class OpenOutputWindowListener implements ActionListener {

    private final OutputPanel thePanel;
    private final ApplicationSettings settings;

    private Student student;

    public OpenOutputWindowListener(OutputPanel panel, ApplicationSettings settings, Student student) {
        this.thePanel = panel;
        this.settings = settings;
        this.student = student;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TrivialEdit editor = new TrivialEdit();
        editor.doOpenOnStart(student.getOutputFileName());
        editor.setVisible(true);
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
