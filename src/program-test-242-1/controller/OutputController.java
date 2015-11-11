package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import view.OutputPanel;

public class OutputController {
    
    /**
     * Sets the text area of the output area to the text from the student's
     * output file.
     * @param panel the panel to refresh
     * @param student the student whose output file to use
     */
    public void refreshOutputPanel(OutputPanel panel, Student student) {
        // Convert the output file to a string.
        String outputString = "";
        File outputFile = new File(student.getOutputFileName());
        try (Scanner in = new Scanner(outputFile)) {
            while (in.hasNext()) {
                String line = in.nextLine();
                outputString +=line + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OutputPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Set the text area to the string.
        panel.getTextArea().setText(outputString);
    }
    
}
