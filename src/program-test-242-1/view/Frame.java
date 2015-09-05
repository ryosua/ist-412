package view;

import controller.FileController;
import javax.swing.JFrame;


public class Frame extends JFrame{
    private final JFrame frame = new JFrame();
    private final MainMenu menu = new MainMenu();
    private final FileController theFileController = new FileController(this);

    public Frame(){
        super("ProgramTester Frame");

        frame.setJMenuBar(menu);
        
        final InputPanel inputPanel = new InputPanel(this, theFileController);
        frame.add(inputPanel);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
