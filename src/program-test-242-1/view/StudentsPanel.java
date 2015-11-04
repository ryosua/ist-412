package view;

import controller.StudentReader;
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

    private final StudentsFrame frame;
    private final ApplicationSettings settings;

    private JCheckBox[] checkBoxes;
    private ArrayList<Student> students;

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
        StudentReader studentReader = new StudentReader(results, settings);
        students = studentReader.readStudentsFromFileStructure();

        JPanel checkBoxesPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(checkBoxesPanel, BoxLayout.Y_AXIS);

        checkBoxes = new JCheckBox[students.size()];
        StudentCheckBoxChangeListener studentCheckBoxChangeListener = new StudentCheckBoxChangeListener(checkBoxes);

        for (int i = 0; i < students.size(); i++) {
            checkBoxes[i] = new JCheckBox(students.get(i).getStudentName());
            checkBoxes[i].addChangeListener(studentCheckBoxChangeListener);
            checkBoxesPanel.add(checkBoxes[i]);
        }
        // Set all of the student check boxes to the select all box's selection.
        selectAllCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boolean selected = selectAllCheckBox.isSelected();

                for (JCheckBox box : checkBoxes) {
                    box.setSelected(selected);
                }
            }
        });

        checkBoxesPanel.setLayout(boxLayout);

        this.add(checkBoxesPanel, BorderLayout.CENTER);
    }

    /**
     * Gets the students that are selected in the window.
     *
     * @param students the students represented by the checkboxes
     * @param checkBoxes
     * @return the students that are selected
     */
    private ArrayList<Student> getStudentsSelected() {
        ArrayList<Student> selectedStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (checkBoxes[i].isSelected() == true) {
                selectedStudents.add(students.get(i));
            }
        }

        return selectedStudents;
    }
    
    private int getNumberOfSelectedStudents() {
        return getStudentsSelected().size();
    }

    private void saveSelectedStudents() {
        settings.setStudents(getStudentsSelected());
    }
    
    private void updateInputPanelTextField() {
        frame.getChooseStudentsListener().getTextField().setText(getNumberOfSelectedStudents() + " students selected.");
    }

    private class StudentCheckBoxChangeListener implements ChangeListener {

        private final JCheckBox[] checkBoxes;

        public StudentCheckBoxChangeListener(JCheckBox[] checkBoxes) {
            this.checkBoxes = checkBoxes;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            JCheckBox box = (JCheckBox) e.getSource();

            for (JCheckBox b : checkBoxes) {
                if (b == box) {
                    saveSelectedStudents();
                    updateInputPanelTextField();
                }
            }
        }
    }

}
