package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.OutputPanel;

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
