package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import model.ApplicationSettings;

public class OutputCheckBoxListener implements ActionListener {

    private ApplicationSettings settings;

    public OutputCheckBoxListener(ApplicationSettings settings) {
        this.settings = settings;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        //String newLabel = (selected ? "A" : "B");
        //abstractButton.setText(newLabel);
        if (selected) {
            System.out.println("Check Box clicked. Value is: " + selected);
            settings.setDisplayOutputCheck(true);
        } else {
            System.out.println("Check Box unclicked. Value is: " + selected);
            settings.setDisplayOutputCheck(false);
        }

    }

}
