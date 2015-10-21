/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import view.TrivialEdit;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationSettings;
import view.OutputPanel;

/**
 *
 * @author qyl5054
 */
public class OpenOutputWindowListener implements ActionListener {

    private final OutputPanel thePanel;
    private final ApplicationSettings settings;

    public OpenOutputWindowListener(OutputPanel panel, ApplicationSettings settings) {
        this.thePanel = panel;
        this.settings = settings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        thePanel.getFrame().setVisible(false);
        File file = settings.getOutputFileDirectory();
        
        TrivialEdit editor = new TrivialEdit();
        editor.doOpenOnStart(file.toString());
        editor.setVisible(true);
    }
}
