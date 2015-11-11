package view;

import controller.OutputController;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
    
    public StudentOutputPanel(OutputPanel outputPanel, ApplicationSettings settings) {
        this.outputPanel = outputPanel;
        this.settings = settings;
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        createComponents();
    }

    private void createComponents() {
        closeButton = new JButton("Close Window");
        closeButton.addActionListener(new CloseOutputWindowListener(outputPanel));

        outputButton = new JButton("Open Output");
        outputButton.addActionListener(new OpenOutputWindowListener(outputPanel, settings));

        sourceButton = new JButton("Open Source");
        sourceButton.addActionListener(new SourceOutputWindowListener(outputPanel, settings));
        
        studentTable = new JTable();
        theModel = new StudentTableModel(settings.getStudents());
        
        studentTable.setModel(theModel);
        
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getSelectionModel().addListSelectionListener(new StudentRowListener());
        
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
    
    
    
    
    
    
    
    private class StudentRowListener implements ListSelectionListener{

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int row = studentTable.getSelectedRow();
        int adjRow = studentTable.convertRowIndexToModel(row);
        OutputController theOutputController = new OutputController();
        theOutputController.refreshOutputPanel(outputPanel, theModel.getStudent(adjRow));
    }
    
}
}
