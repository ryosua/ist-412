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
            
            
            //******Image Panel Controls******
            //Advance the image displayed by 1.
            imagePanel.setCurrentImageCounter(imagePanel.getCurrentImageCounter() + 1);
            if(imagePanel.getCurrentImageCounter() > 14){
                imagePanel.setCurrentImageCounter(0);
            }
            
            imagePanel.setDisplayedImage();
        }
        if(obj == previousButton){
            //******Text Panel Controls******
            
            
            //******Image Panel Controls******
            //Reverse the image displayed by 1.
            imagePanel.setCurrentImageCounter(imagePanel.getCurrentImageCounter() - 1);
            if(imagePanel.getCurrentImageCounter() < 0){
                imagePanel.setCurrentImageCounter(14);
            }
            
            imagePanel.setDisplayedImage();
        }
    }
}
