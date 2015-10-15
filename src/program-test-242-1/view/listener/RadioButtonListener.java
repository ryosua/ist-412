/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import controller.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import model.ApplicationSettings;

/**
 *
 * @author Xelerate
 */
public class RadioButtonListener implements ActionListener {
    private final JRadioButton singleRun, batchRun;
    private final Main main;
    
    public RadioButtonListener(Main main, JRadioButton singleRun, JRadioButton batchRun) {
        this.singleRun = singleRun;
        this.batchRun = batchRun;
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if (source == singleRun) {
           System.out.println("Single Run selected.");
           main.getSettings().setRunMode(ApplicationSettings.SINGLE_MODE);
       }
       else if (source == batchRun) {
           System.out.println("Batch Run selected.");
           main.getSettings().setRunMode(ApplicationSettings.BATCH_MODE);
       }
    }
    
}
