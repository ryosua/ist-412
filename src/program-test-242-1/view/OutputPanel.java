/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import view.listener.CloseOutputWindowListener;
import view.listener.OpenOutputWindowListener;
import view.listener.SourceOutputWindowListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationSettings;

/**
 *
 * @author dos5385
 */
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

    public OutputFrame getFrame() {
        return theFrame;
    }
}
