/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.listener.CloseOutputWindowListener;
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
    private OutputFrame theFrame;
    
    public OutputPanel(OutputFrame frame, String results){
        theFrame = frame;
        this.results = results;

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
    }
    
    public OutputFrame getFrame(){
        return theFrame;
    }
}
