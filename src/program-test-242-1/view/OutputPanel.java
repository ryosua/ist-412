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
    private final JButton closeButton, outputButton, sourceButton;
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
       
        closeButton = new JButton("Close Window");
        closeButton.addActionListener(new CloseOutputWindowListener(this));

        outputButton = new JButton("Open Output");
        outputButton.addActionListener(new OpenOutputWindowListener(this, settings));


        sourceButton = new JButton("Open Source");
        sourceButton.addActionListener(new SourceOutputWindowListener(this, settings));
        
        this.add(closeButton, BorderLayout.WEST);
        this.add(outputButton, BorderLayout.EAST);
        this.add(outputArea, BorderLayout.CENTER);
        this.add(sourceButton, BorderLayout.NORTH);
    }

    public OutputFrame getFrame() {
        return theFrame;
    }
}
