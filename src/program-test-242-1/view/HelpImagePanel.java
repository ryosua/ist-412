package view;

import controller.Main;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ApplicationSettings;

public class HelpImagePanel extends JPanel{
    private ArrayList<ImageIcon> tutorialImages;
    private Main main;
    private ApplicationSettings settings;
    private int displayedImage;
    private String rootImageName;
    private JLabel image;
    
    public HelpImagePanel(){
        main = new Main();
        settings = main.getSettings();
        tutorialImages = new ArrayList<ImageIcon>();
        displayedImage = 0;
        rootImageName = "tutorialImage";
        
        //addImages(settings.getTutorialImageDirectory());
        //setupPanel();
    }
    
    //Adds images to to list which will be used to cycle through tutorial steps.
    //Must have the same number of images as there are steps (text file lines) within the tutorial
    //  text file since each step displays both an image and text.
    private void addImages(File directory){        
        for(int i = 0; i < directory.listFiles().length; i++){
            tutorialImages.add(new ImageIcon(directory + "/" + rootImageName + i + ".png"));
            //System.out.println("Directory Array: " + directory.listFiles()[i]);
        }
        //Debug
        //System.out.println("Help Image Array: " + tutorialImages.toString());
        //System.out.println("Directory Files: " + directory.listFiles().length);
    }
    
    public void setCurrentImageCounter(int img){
        displayedImage = img;
    }
    
    public int getCurrentImageCounter(){
        return displayedImage;
    }
    
    public ArrayList<ImageIcon> getImageArray(){
        return tutorialImages;
    }
    
    public void setDisplayedImage(){
        image.setIcon(tutorialImages.get(getCurrentImageCounter()));
    }
    
    public void setupPanel(){
        addImages(settings.getTutorialImageDirectory());
        
        //Sets panel to 1st image default
        setCurrentImageCounter(0);
        image = new JLabel(tutorialImages.get(this.getCurrentImageCounter()));
        
        add(image);
        setVisible(true);
    }
}