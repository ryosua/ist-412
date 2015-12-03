package view;

import controller.Main;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenu extends JMenuBar {

    private final JMenuBar menu;
    private final JMenu menuFile, documentation;
    private final JMenuItem closeApp, help, readme;
    private final Main main;
    private final InputPanel panel;

    public MainMenu(Main main) {
        this.main = main;

        //Set up menu bar
        menu = new JMenuBar();
        panel = new InputPanel(main);

        //Set up menu items that are displayed on bar.
        menuFile = new JMenu("File");
        documentation = new JMenu("Documentation");

        //Set up menu sub-items that are shown beneath a menu item.
        closeApp = new JMenuItem("Exit");
        help = new JMenuItem("Display Program Help");
        readme = new JMenuItem("Open Readme");

        //Add listeners
        closeApp.addActionListener(new menuExitApp());
        help.addActionListener(new helpOpener());
        readme.addActionListener(new readmeOpener());

        //Add options to the menubar.
        this.add(menuFile);
        this.add(documentation);

        //Adds options in dropdown format for menu item.
        menuFile.add(closeApp);
        documentation.add(help);
        documentation.add(readme);
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

        private HelpFrame helpFrame;

        public helpOpener() {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            helpFrame = new HelpFrame(main);
            helpFrame.getTextPanel().setupPanel();
            helpFrame.getImagePanel().setupPanel();
            helpFrame.getButtonPanel().setupPanel();
            helpFrame.setVisible(true);
        }
    }

    private class readmeOpener implements ActionListener {

        private File readme;

        public readmeOpener() {
            try {
                readme = new File(main.getSettings().getRootDirectory().getAbsolutePath() + "/readme.txt");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "File Not Found", "Readme File Could Not Be Found", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(readme);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
}
