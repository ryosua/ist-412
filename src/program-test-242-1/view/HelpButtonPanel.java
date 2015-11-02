package view;

import controller.Main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpButtonPanel extends JPanel implements ActionListener{
    private final JButton nextButton, previousButton;
    private HelpTextPanel textPanel;
    private HelpImagePanel imagePanel;
    
    public HelpButtonPanel(HelpTextPanel text, HelpImagePanel image){
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        
        textPanel = text;
        imagePanel = image;
        
        setupPanel();
    }
    
    public void setupPanel(){
        setPreferredSize(new Dimension(500, 50));
        
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        
        add(previousButton);
        add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == nextButton){
            //******Text Panel Controls******
            textPanel.setCurrentTextCounter(textPanel.getCurrentTextCounter() + 1);
            System.out.println(textPanel.getCurrentTextCounter());
            
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
            
            imagePanel.setDisplayedImage();
            textPanel.addTextToPanel();
        }
        if(obj == previousButton){
            //******Text Panel Controls******
            textPanel.setCurrentTextCounter(textPanel.getCurrentTextCounter() - 1);
            System.out.println(textPanel.getCurrentTextCounter());
            
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
            
            imagePanel.setDisplayedImage();
            textPanel.addTextToPanel();
        }
    }
}
