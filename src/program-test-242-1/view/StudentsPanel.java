package view;

import controller.BatchConfigReader;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.ApplicationSettings;
import model.Results;
import model.Student;

public class StudentsPanel extends JPanel {
    
    private final JFrame frame;
    private final ApplicationSettings settings;

    public StudentsPanel(StudentsFrame frame, ApplicationSettings settings) {
        this.frame = frame;
        this.settings = settings;
        
        createComponents();
    }
    
    private void createComponents() {
        JCheckBox selectAllCheckBox = new JCheckBox("Select All");
        this.add(selectAllCheckBox);
        
        // TEMPORARY - We need to refactor this class, or get an instance from BatchTester.
        Results results = new Results();
            
        // Read students from config.
        BatchConfigReader studentReader = new BatchConfigReader(results, settings);
        ArrayList<Student> students = studentReader.readStudentsFromConfig();
        
        for (Student student: students) {
            JCheckBox studentCheckbox = new JCheckBox(student.getStudentPath());
            this.add(studentCheckbox);
        }
    }
    
}
