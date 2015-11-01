package view;

import controller.Main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpButtonPanel extends JPanel implements ActionListener{
    private final JButton nextButton, previousButton;
    
    public HelpButtonPanel(){
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        setupPanel();
    }
    
    public void setupPanel(){
        setPreferredSize(new Dimension(500, 50));
        
        nextButton.addActionListener(this);
        
        add(previousButton);
        add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
