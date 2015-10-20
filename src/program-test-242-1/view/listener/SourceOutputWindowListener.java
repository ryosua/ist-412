/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import view.OutputPanel;

/**
 *
 * @author qyl5054
 */
public class SourceOutputWindowListener implements ActionListener{
    private OutputPanel thePanel;
    public SourceOutputWindowListener(OutputPanel panel){
        thePanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        thePanel.getFrame().setVisible(false);
        Desktop desktop = null;
        // on Windows, retrieve the path of the "Program Files" folder
        //File file = new File(System.getenv("programfiles"));
        File file = new File("C:/java/src/program-test-242-1/src/src-output");
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(file);
            }
        catch (IOException evt){  
        throw new RuntimeException(evt);
        }
    }
}    
