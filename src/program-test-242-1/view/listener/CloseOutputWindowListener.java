/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.OutputPanel;

/**
 *
 * @author dos5385
 */
public class CloseOutputWindowListener implements ActionListener {

    private OutputPanel thePanel;

    public CloseOutputWindowListener(OutputPanel panel) {
        thePanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        thePanel.getFrame().setVisible(false);
    }
}
