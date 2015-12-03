package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.ApplicationSettings;

public class OutputPanel extends JPanel {

    private final ApplicationSettings settings;
    private final JTextArea outputArea;
    private final String results;
    private final OutputFrame theFrame;
    private final JScrollPane scrollPane;

    public OutputPanel(OutputFrame frame, String results, ApplicationSettings settings) {
        theFrame = frame;
        this.results = results;
        this.settings = settings;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        outputArea = new JTextArea(results);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(false);
        
        scrollPane = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(theFrame.getPreferredSize());

        StudentOutputPanel studentOutputPanel = new StudentOutputPanel(this, settings);

        this.add(studentOutputPanel, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public OutputFrame getFrame() {
        return theFrame;
    }

    public JTextArea getTextArea() {
        return outputArea;
    }
}
