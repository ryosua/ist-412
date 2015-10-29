package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpButtonPanel extends JPanel{
    private final JButton nextButton, previousButton;
    
    public HelpButtonPanel(){
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        setupPanel();
        
        //Debug
        repaint();
    }
    
    //Debug
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void setupPanel(){
        setPreferredSize(new Dimension(500, 50));
        add(previousButton);
        add(nextButton);
    }
}
