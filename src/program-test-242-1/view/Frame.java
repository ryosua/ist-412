package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
    JFrame frame = new JFrame();
    MainMenu menu = new MainMenu();

    public Frame(){
        super("ProgramTester Frame");

        frame.setJMenuBar(menu);
        
        final InputPanel inputPanel = new InputPanel(this);
        frame.add(inputPanel);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
