package view;

import controller.listener.ChooseConfigLocationListener;
import controller.listener.ChooseJDKLocationListener;
import controller.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.JRadioButtonMenuItem;

public class MainMenu extends JMenuBar{
    private JMenuBar menu;
    private JMenu menuFile, menuRunType, menuConfig;
    private JMenuItem closeApp, selectConfig, selectJDK;
    private Main main;

    public MainMenu(Main main){
        this.main = main;
        //Set up menu bar
        menu = new JMenuBar();

        //Set up menu items that are displayed on bar.
        menuFile = new JMenu("File");
        menuRunType = new JMenu("Run Type");
        menuConfig = new JMenu("Config");

        //Set up menu sub-items that are shown beneath a menu item.
        closeApp = new JMenuItem("Exit");
        selectConfig = new JMenuItem("Select Config File");
        selectJDK = new JMenuItem("Select JDK");
        
        //Add listeners
        //***Need to get textfield from InputPanel here to replace nulls.***
        selectConfig.addActionListener(new ChooseConfigLocationListener(main, null));
        selectJDK.addActionListener(new ChooseJDKLocationListener(main, null));
        closeApp.addActionListener(new menuExitApp());

        //Add options to the menubar.
        this.add(menuFile);
        this.add(menuConfig);

        //Adds options in dropdown format for menu item.
        menuFile.add(closeApp);
        menuConfig.add(selectJDK);
        menuConfig.add(selectConfig);
    }
    
    public JMenuItem getConfigMenuButton(){
        return selectConfig;
    }
    
    public JMenuItem getJDKMenuButton(){
        return selectJDK;
    }
    
    private class menuExitApp implements ActionListener {

        public menuExitApp() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) { System.exit(0); } //Exits application
    }
}
