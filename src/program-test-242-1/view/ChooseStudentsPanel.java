package view;

import controller.StudentReader;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ApplicationSettings;
import model.Student;

public class ChooseStudentsPanel extends JPanel {

    private final ChooseStudentsFrame frame;
    private final ApplicationSettings settings;

    private JCheckBox[] checkBoxes;
    private JPanel checkBoxesPanel;
    private JScrollPane scrollPane;
    private JPanel buttonPanel = new JPanel();
    private final JButton okButton = new JButton("Ok");
    private ArrayList<Student> students;

    public ChooseStudentsPanel(ChooseStudentsFrame frame, ApplicationSettings settings) {
        this.frame = frame;
        this.settings = settings;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        createComponents();
    }

    private void createComponents() {
        final JCheckBox selectAllCheckBox = new JCheckBox("Select All");
        this.add(selectAllCheckBox, BorderLayout.NORTH);

        // Read students from config.
        StudentReader studentReader = new StudentReader(settings);
        students = studentReader.readStudentsFromFileStructure();

        checkBoxesPanel = new JPanel();
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
                repaint(); //Fixes graphical issue when select all is clicked rapidly.
            }
        });

        checkBoxesPanel.setLayout(boxLayout);

        okButton.setMaximumSize(new Dimension(80, 10));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        scrollPane = new JScrollPane(checkBoxesPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
        this.add(buttonPanel, BorderLayout.PAGE_END);
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

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        frame.setChooseStudentsListener(false);
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
