package view;

import view.listener.ChooseStudentsListener;
import view.listener.ChooseJDKLocationListener;
import controller.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar{
    private final JMenuBar menu;
    private final JMenu menuFile;
    private final JMenuItem closeApp, help;
    private final Main main;
    private final InputPanel panel;

    public MainMenu(Main main){
        this.main = main;
        
        //Set up menu bar
        menu = new JMenuBar();
        panel = new InputPanel(main);
        
        //Set up menu items that are displayed on bar.
        menuFile = new JMenu("File");

        //Set up menu sub-items that are shown beneath a menu item.
        closeApp = new JMenuItem("Exit");
        help = new JMenuItem("Help");
                
        //Add listeners
        closeApp.addActionListener(new menuExitApp());
        help.addActionListener(new helpOpener());

        //Add options to the menubar.
        this.add(menuFile);
        this.add(help);

        //Adds options in dropdown format for menu item.
        menuFile.add(closeApp);
    }
    
    private class menuExitApp implements ActionListener {

        public menuExitApp() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0); //Exits application
        }
    }
    
    private class helpOpener implements ActionListener {
        private final HelpFrame helpFrame;
        
        public helpOpener() {
            helpFrame = new HelpFrame();
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Help Clicked.");
            helpFrame.setVisible(true);
        }
    }
}
