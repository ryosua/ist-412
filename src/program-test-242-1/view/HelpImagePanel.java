package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HelpImagePanel extends JPanel{
    private ArrayList<ImageIcon> tutorialImages;
    
    public HelpImagePanel(){
        
        //Debug
        repaint();
    }
    
    //Debug
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.blue);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void setupPanel(){
        setVisible(true);
    }
}
