/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import model.ApplicationSettings;

/**
 *
 * @author dos5385
 */
public class OutputCheckBoxListener implements ActionListener{

    private ApplicationSettings settings;
    public OutputCheckBoxListener(ApplicationSettings settings){
        this.settings = settings;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        //String newLabel = (selected ? "A" : "B");
        //abstractButton.setText(newLabel);
        if(selected){
            System.out.println("Check Box clicked. Value is: " + selected);
            settings.setDisplayOutputCheck(Boolean.TRUE.toString());
        }else{
            System.out.println("Check Box unclicked. Value is: " + selected);
            settings.setDisplayOutputCheck(Boolean.FALSE.toString());
        }
        
    }
    
}
