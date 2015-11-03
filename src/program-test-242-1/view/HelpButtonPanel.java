package view;

import controller.Main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpButtonPanel extends JPanel implements ActionListener{
    private final JButton nextButton, previousButton;
    private JLabel stepLabel;
    private HelpTextPanel textPanel;
    private HelpImagePanel imagePanel;
    private int totalSteps;
    
    public HelpButtonPanel(HelpTextPanel text, HelpImagePanel image){
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        stepLabel = new JLabel();
        totalSteps = 0;
        
        textPanel = text;
        imagePanel = image;
        
        setupPanel();
    }
    
    public void setupPanel(){        
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        
        if(imagePanel.getImageArray().size() == textPanel.getTextArray().size()){
            totalSteps = imagePanel.getImageArray().size();
            updateStepLabel();
        }else{
            System.out.println("Array Size Mismatch.");
            stepLabel.setText("Array Size Mismatch.");
            totalSteps = 0;
        }
        
        add(previousButton);
        add(nextButton);
        add(stepLabel);
    }
    
    private void updateStepLabel(){
        if(imagePanel.getCurrentImageCounter() == textPanel.getCurrentTextCounter()){
            stepLabel.setText("Step: " + Integer.toString(imagePanel.getCurrentImageCounter() + 1) + "/" + Integer.toString(totalSteps));
        }else{
            System.out.println("Step Counters Mismatch.");
            stepLabel.setText("Step Counters Mismatch.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == nextButton){
            //******Text Panel Controls******
            textPanel.setCurrentTextCounter(textPanel.getCurrentTextCounter() + 1);
            
            //Reset Counter to last place in order to loop back through steps.
            if(textPanel.getCurrentTextCounter() > textPanel.getTextArray().size() - 1){
                textPanel.setCurrentTextCounter(0);
            }
            
            
            //******Image Panel Controls******
            //Advance the image displayed by 1.
            imagePanel.setCurrentImageCounter(imagePanel.getCurrentImageCounter() + 1);
            
            //Reset counter to last place in order to loop back through steps.
            if(imagePanel.getCurrentImageCounter() > imagePanel.getImageArray().size() - 1){
                imagePanel.setCurrentImageCounter(0);
            }
            
            //******Step Label Controls******
            updateStepLabel();
            
            imagePanel.setDisplayedImage();
            textPanel.addTextToPanel();
        }
        if(obj == previousButton){
            //******Text Panel Controls******
            textPanel.setCurrentTextCounter(textPanel.getCurrentTextCounter() - 1);
            
            if(textPanel.getCurrentTextCounter() < 0){
                textPanel.setCurrentTextCounter(textPanel.getTextArray().size() - 1);
            }
            
            //******Image Panel Controls******
            //Reverse the image displayed by 1.
            imagePanel.setCurrentImageCounter(imagePanel.getCurrentImageCounter() - 1);
            
            //Reset counter to last place in order to loop back through steps.
            if(imagePanel.getCurrentImageCounter() < 0){
                imagePanel.setCurrentImageCounter(imagePanel.getImageArray().size() - 1);
            }
            
            //******Step Label Controls******
            updateStepLabel();
            
            imagePanel.setDisplayedImage();
            textPanel.addTextToPanel();
        }
    }
}
