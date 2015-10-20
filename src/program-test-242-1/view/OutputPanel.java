/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.listener.CloseOutputWindowListener;
import view.listener.OpenOutputWindowListener;
import view.listener.SourceOutputWindowListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

    private JTextArea outputArea;
    private JButton closeButton, outputButton, sourceButton;
    private String results;
    private OutputFrame theFrame;

    public OutputPanel(OutputFrame frame, String results, ApplicationSettings settings) {
        theFrame = frame;
        this.results = results;
        this.settings = settings;

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        outputArea = new JTextArea(results);
        outputArea.setEditable(false);
        GridBagConstraints outputAreaC = new GridBagConstraints();
        outputAreaC.fill = GridBagConstraints.HORIZONTAL;
        outputAreaC.gridx = 0;
        outputAreaC.gridy = 0;
        outputAreaC.gridheight = 10;
        outputAreaC.gridwidth = 10;

        closeButton = new JButton("Close Window");
        closeButton.addActionListener(new CloseOutputWindowListener(this));
        GridBagConstraints closeButtonC = new GridBagConstraints();
        closeButtonC.fill = GridBagConstraints.HORIZONTAL;
        closeButtonC.gridx = 0;
        closeButtonC.gridy = 11;
        closeButtonC.gridwidth = 1;

        this.add(outputArea, outputAreaC);
        this.add(closeButton, closeButtonC);

        outputButton = new JButton("Open Output");
        outputButton.addActionListener(new OpenOutputWindowListener(this, settings));
        GridBagConstraints outputButtonC = new GridBagConstraints();
        outputButtonC.fill = GridBagConstraints.HORIZONTAL;
        outputButtonC.gridx = 14;
        outputButtonC.gridy = 0;
        outputButtonC.gridwidth = 1;

        this.add(outputArea, outputAreaC);
        this.add(outputButton, outputButtonC);

        sourceButton = new JButton("Open Source");
        sourceButton.addActionListener(new SourceOutputWindowListener(this, settings));
        GridBagConstraints sourceButtonC = new GridBagConstraints();
        sourceButtonC.fill = GridBagConstraints.HORIZONTAL;
        sourceButtonC.gridx = 14;
        sourceButtonC.gridy = 1;
        sourceButtonC.gridwidth = 1;

        this.add(outputArea, outputAreaC);
        this.add(sourceButton, sourceButtonC);
    }

    public OutputFrame getFrame() {
        return theFrame;
    }
}
