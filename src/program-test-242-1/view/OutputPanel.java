/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author dos5385
 */
public class OutputPanel extends JPanel{
    
    private JTextArea outputArea;
    private JButton closeButton;
    private String results;
    
    public OutputPanel(String results){
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        this.results = results;
        outputArea = new JTextArea(results);
        GridBagConstraints outputAreaC = new GridBagConstraints();
        outputAreaC.fill = GridBagConstraints.HORIZONTAL;
        outputAreaC.gridx = 0;
        outputAreaC.gridy = 0;
        outputAreaC.gridheight = 10;
        outputAreaC.gridwidth = 5;
        
        
        closeButton = new JButton("Close Window");
        GridBagConstraints closeButtonC = new GridBagConstraints();
        closeButtonC.fill = GridBagConstraints.HORIZONTAL;
        closeButtonC.gridx = 0;
        closeButtonC.gridy = 11;
        closeButtonC.gridwidth = 1;
        
        this.add(outputArea, outputAreaC);
        this.add(closeButton, closeButtonC);
    }
}
