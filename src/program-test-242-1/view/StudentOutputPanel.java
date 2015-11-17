package view;

import controller.OutputController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.ApplicationSettings;
import model.Student;
import model.StudentTableModel;
import view.listener.CloseOutputWindowListener;
import view.listener.OpenOutputWindowListener;
import view.listener.SourceOutputWindowListener;

public class StudentOutputPanel extends JPanel {

    private final OutputPanel outputPanel;
    private final ApplicationSettings settings;

    private JButton closeButton;
    private JButton outputButton;
    private JButton sourceButton;
    private JTable studentTable;
    private StudentTableModel theModel;
    private OpenOutputWindowListener outputListener;
    private SourceOutputWindowListener sourceListener;

    public StudentOutputPanel(OutputPanel outputPanel, ApplicationSettings settings) {
        this.outputPanel = outputPanel;
        this.settings = settings;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        createComponents();
    }

    private void createComponents() {
        
        ArrayList<Student> students = settings.getStudents();
                
        closeButton = new JButton("Close Window");
        closeButton.addActionListener(new CloseOutputWindowListener(outputPanel));
        
        outputListener = new OpenOutputWindowListener(outputPanel, settings, students.get(0));
        outputButton = new JButton("Open Output");
        outputButton.addActionListener(outputListener);

        sourceListener = new SourceOutputWindowListener(outputPanel, settings, students.get(0));
        sourceButton = new JButton("Open Source");
        sourceButton.addActionListener(sourceListener);

        studentTable = new JTable();
        theModel = new StudentTableModel(students);

        studentTable.setModel(theModel);

        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getSelectionModel().addListSelectionListener(new StudentRowListener());
        studentTable.setRowSelectionInterval(0, 0);

        JScrollPane theStudentScrollPane = new JScrollPane(studentTable);

        theStudentScrollPane.setPreferredSize(new Dimension(100, this.getHeight()));
        JPanel buttonPanel = new JPanel();
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout);

        buttonPanel.add(outputButton);
        buttonPanel.add(sourceButton);
        buttonPanel.add(closeButton);

        this.add(theStudentScrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private class StudentRowListener implements ListSelectionListener {
        
        private final OutputController theOutputController;
        
        public StudentRowListener() {
            this.theOutputController = new OutputController();
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int row = studentTable.getSelectedRow();
            int adjRow = studentTable.convertRowIndexToModel(row);
            Student selectedStudent = theModel.getStudent(adjRow);
            theOutputController.refreshOutputPanel(outputPanel, selectedStudent);
            outputListener.setStudent(selectedStudent);
            sourceListener.setStudent(selectedStudent);
        }

    }
}
