package view;

import controller.BatchConfigReader;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ApplicationSettings;
import model.Results;
import model.Student;

public class StudentsPanel extends JPanel {

    private final JFrame frame;
    private final ApplicationSettings settings;

    public StudentsPanel(StudentsFrame frame, ApplicationSettings settings) {
        this.frame = frame;
        this.settings = settings;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        createComponents();
    }

    private void createComponents() {
        final JCheckBox selectAllCheckBox = new JCheckBox("Select All");
        this.add(selectAllCheckBox, BorderLayout.NORTH);

        // TEMPORARY - We need to refactor this class, or get an instance from BatchTester.
        Results results = new Results();

        // Read students from config.
        BatchConfigReader studentReader = new BatchConfigReader(results, settings);
        ArrayList<Student> students = studentReader.readStudentsFromConfig();

        JPanel checkBoxesPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(checkBoxesPanel, BoxLayout.Y_AXIS);

        final JCheckBox[] checkBoxes = new JCheckBox[students.size()];

        for (int i = 0; i < students.size(); i++) {
            checkBoxes[i] = new JCheckBox(students.get(i).getStudentName());
            checkBoxesPanel.add(checkBoxes[i]);
        }
        // Set all of the student check boxes to the select all box's selection.
        selectAllCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boolean selected = selectAllCheckBox.isSelected();
               
                for(JCheckBox box: checkBoxes) {
                    box.setSelected(selected);
                }
            }
        });

        checkBoxesPanel.setLayout(boxLayout);

        this.add(checkBoxesPanel, BorderLayout.CENTER);
    }

}
