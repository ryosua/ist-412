package view;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.ApplicationSettings;
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
        
        JScrollPane theStudentScrollPane = new JScrollPane();
        
        JTable studentTable = new JTable();
        studentTable.setModel(new StudentTableModel(settings.getStudents()));
        
        
        JPanel buttonPanel = new JPanel();
        BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout);
        
        buttonPanel.add(outputButton);
        buttonPanel.add(sourceButton);
        buttonPanel.add(closeButton);
        
        this.add(theStudentScrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
