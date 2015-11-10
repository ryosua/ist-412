package view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationSettings;
import model.Student;

public class OutputPanel extends JPanel {

    private final ApplicationSettings settings;

    private final JTextArea outputArea;
    private final String results;
    private final OutputFrame theFrame;

    public OutputPanel(OutputFrame frame, String results, ApplicationSettings settings) {
        theFrame = frame;
        this.results = results;
        this.settings = settings;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        outputArea = new JTextArea(results);
        outputArea.setEditable(false);

        StudentOutputPanel studentOutputPanel = new StudentOutputPanel(this, settings);

        this.add(studentOutputPanel, BorderLayout.WEST);
        this.add(outputArea, BorderLayout.CENTER);
    }
    
    /**
     * Sets the text area of the output area to the text from the student's
     * output file.
     * @param student the student whose output file to display
     */
    public void refresh(Student student) {
        // Convert the output file to a string.
        String outputString = "";
        File outputFile = new File(student.getOutputFileName());
        try (Scanner in = new Scanner(outputFile)) {
            while (in.hasNext()) {
                String line = in.nextLine();
                outputString +=line;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OutputPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Set the text area to the string.
        outputArea.setText(outputString);
    }

    public OutputFrame getFrame() {
        return theFrame;
    }
}