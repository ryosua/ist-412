package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelpFrame extends JFrame{
    private HelpTextPanel textPanel;
    private HelpImagePanel imagePanel;
    private HelpButtonPanel buttonPanel;
    
    public HelpFrame(){
        initFrame();
    }
    
    public void initFrame(){
        setSize(800, 600);
        setTitle("Help");
        setLayout(new BorderLayout());
        
        textPanel = new HelpTextPanel();
        imagePanel = new HelpImagePanel();
        buttonPanel = new HelpButtonPanel(textPanel, imagePanel);
        
        add(textPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}