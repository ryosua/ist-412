package view;

import controller.Main;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationSettings;

public class HelpTextPanel extends JPanel{
    private JTextArea tutorialText;
    private File tutorialTextFile;
    private Main main;
    private int rows;
    private int columns;
    
    public HelpTextPanel(){
        main = new Main();
        
        //Setup the panel
        setupPanel();
        
        //Setup the textfile pathing
        setupTutorialFile(main.getSettings());
        
        //Read the textfile and write into the panel.
        writeTextToPanel(tutorialTextFile);
    }

    private void setupPanel(){
        rows = 30;
        columns = 30;
        tutorialText = new JTextArea(rows, columns);
        tutorialText.setEditable(false);
        
        add(tutorialText);
    }
    
    //Store path for tutorial textfile in settings?
    private void setupTutorialFile(ApplicationSettings settings){
        tutorialTextFile = new File(settings.getTutorialTextDirectory().getAbsolutePath());
    }
    
    private void writeTextToPanel(File text){
        
    }
}
