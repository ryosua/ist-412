package view;

import controller.FileController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFileChooser;

/**
 * Created by Shane on 9/2/15.
 */
public class MainMenu extends JMenuBar{
    private JMenuBar menu;
    private JMenu menuFile, menuRunType, menuConfig;
    private JMenuItem closeApp, selectConfig, selectJDK;
    private JRadioButtonMenuItem singleRun, batchRun;
    private ButtonGroup menuRunTypeRadios;
    private final FileController theFileController;

    public MainMenu(FileController theFileController){
        
        this.theFileController = theFileController;
        //Set up menu bar
        menu = new JMenuBar();

        //Set up menu items that are displayed on bar.
        menuFile = new JMenu("File");
        menuRunType = new JMenu("Run Type");
        menuConfig = new JMenu("Config");

        //Set up menu sub-items that are shown beneath a menu item.
        closeApp = new JMenuItem("Exit");
        selectConfig = new JMenuItem("Select Config File"); //Select Source Directory
        selectJDK = new JMenuItem("Select JDK");

        //Add listeners
        selectConfig.addActionListener(new MenuItemListener());
        selectJDK.addActionListener(new MenuJDK());
        closeApp.addActionListener(new menuExitApp());

        //Set up button group for menu radio buttons.
        menuRunTypeRadios = new ButtonGroup();

        //Set up menu radio button sub-items.
        singleRun = new JRadioButtonMenuItem("Single Run");
        batchRun = new JRadioButtonMenuItem("Batch Run");

        //Set default selection for run type.
        singleRun.setSelected(true);

        //Add radio buttons to button group.
        menuRunTypeRadios.add(singleRun);
        menuRunTypeRadios.add(batchRun);

        //Add options to the menubar.
        this.add(menuFile);
        this.add(menuRunType);
        this.add(menuConfig);

        //Adds options in dropdown format for menu item.
        menuFile.add(closeApp);
        menuConfig.add(selectJDK);
        menuConfig.add(selectConfig);
        menuRunType.add(singleRun);
        menuRunType.add(batchRun);
    }

    private class MenuItemListener implements ActionListener {

        public MenuItemListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) { theFileController.getFileFromChooser(JFileChooser.SAVE_DIALOG); }
    }
    
    private class MenuJDK implements ActionListener {

        public MenuJDK() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            theFileController.getFileFromChooser(JFileChooser.SAVE_DIALOG);
        }
    }

    private class menuExitApp implements ActionListener {

        public menuExitApp() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) { System.exit(0); } //Exits application
    }
}
