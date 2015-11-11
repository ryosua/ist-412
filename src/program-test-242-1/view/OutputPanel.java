package view;

import controller.OutputController;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationSettings;

public class OutputPanel extends JPanel {

    private final OutputController outputController;
    private final ApplicationSettings settings;
    private final JTextArea outputArea;
    private final String results;
    private final OutputFrame theFrame;

    public OutputPanel(OutputFrame frame, String results, ApplicationSettings settings, OutputController outputController) {
        theFrame = frame;
        this.results = results;
        this.settings = settings;
        this.outputController = outputController;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        outputArea = new JTextArea(results);
        outputArea.setEditable(false);

        StudentOutputPanel studentOutputPanel = new StudentOutputPanel(this, settings);

        this.add(studentOutputPanel, BorderLayout.WEST);
        this.add(outputArea, BorderLayout.CENTER);
    }

    public OutputFrame getFrame() {
        return theFrame;
    }

    public JTextArea getTextArea() {
        return outputArea;
    }
}
