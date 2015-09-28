/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Xelerate
 */
public class RadioButtonListener implements ActionListener {
    private final JRadioButton singleRun, batchRun;
    
    public RadioButtonListener(JRadioButton singleRun, JRadioButton batchRun) {
        this.singleRun = singleRun;
        this.batchRun = batchRun;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if (source == singleRun) {
           System.out.println("Single Run selected.");
       }
       else if (source == batchRun) {
           System.out.println("Batch Run selected.");
       }
    }
    
}
