package view;

import controller.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.ApplicationSettings;

public class HelpTextPanel extends JPanel{
    private ArrayList<String> tutorialText;
    private JTextArea tutorialTextArea;
    private File tutorialTextFile;
    private Main main;
    private int rows;
    private int columns;
    private int currentText;
    
    public HelpTextPanel(){
        main = new Main();
        tutorialText = new ArrayList<String>();
        
        //Setup the panel
        setupPanel();
        
        //Setup the textfile pathing
        setupTutorialFile(main.getSettings());
        
        //Add text for steps
        readTextStepsFromFile(tutorialTextFile);
        
        //Read the textfile and write into the panel.
        addTextToPanel();
    }

    private void setupPanel(){
        currentText = 0;
        rows = 10;
        columns = 50;
        tutorialTextArea = new JTextArea(rows, columns);
        tutorialTextArea.setEditable(false);
        
        add(tutorialTextArea);
    }
    
    //Store path for tutorial textfile in settings?
    private void setupTutorialFile(ApplicationSettings settings){
        tutorialTextFile = new File(settings.getTutorialTextDirectory().getAbsolutePath());
    }
    
    private void readTextStepsFromFile(File text){
        try{
            Scanner in = new Scanner(text);
            while(in.hasNextLine()){
                String line = in.nextLine();
                        
                if(!line.equals("")){
                    tutorialText.add(line);
                }
            }
            //Debug
            System.out.println(tutorialText.toString());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void setCurrentTextCounter(int text){
        currentText = text;
    }
    
    public int getCurrentTextCounter(){
        return currentText;
    }
    
    public ArrayList<String> getTextArray(){
        return tutorialText;
    }
    
    public void addTextToPanel(){
        tutorialTextArea.setText(tutorialText.get(getCurrentTextCounter()));
    }
}
