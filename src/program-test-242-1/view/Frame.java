package view;

import controller.Main;
import javax.swing.JFrame;


public class Frame extends JFrame {
    private final JFrame frame;
    private final FileChooser theFileController;
    private final Main main;
    private final MainMenu menu;

    public Frame(Main main){
        super("ProgramTester Frame");
        
        this.main = main;
        
        frame = new JFrame();
        theFileController = new FileChooser(main);
        menu = new MainMenu(main);
       
        frame.setJMenuBar(menu);
        
        final InputPanel inputPanel = new InputPanel(main);
        frame.add(inputPanel);

        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
