package view.listener;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import model.ApplicationSettings;
import model.Student;
import view.OutputPanel;

public class SourceOutputWindowListener implements ActionListener {

    private final OutputPanel thePanel;
    private final ApplicationSettings settings;

    private Student student;

    public SourceOutputWindowListener(OutputPanel panel, ApplicationSettings settings, Student student) {
        this.thePanel = panel;
        this.settings = settings;
        this.student = student;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Desktop desktop = null;
        // on Windows, retrieve the path of the "Program Files" folder
        //File file = new File(System.getenv("programfiles"));
        File file = new File(student.getStudentPath());
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(file);
        } catch (IOException evt) {
            throw new RuntimeException(evt);
        }
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
