import javax.swing.JFrame;

/**
 * Created by Shane on 9/2/15.
 */
public class Frame extends JFrame{
    JFrame frame = new JFrame();
    MainMenu menu = new MainMenu();

    public Frame(){
        super("Test Menu Frame");

        frame.setJMenuBar(menu);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
