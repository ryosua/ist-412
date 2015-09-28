package controller;

import javax.swing.JFrame;
import model.ApplicationSettings;
import view.Frame;
import view.InputPanel;

public class Main {

    private final Frame f;
    private final FileController fileController;
    private final ApplicationSettings settings;
   
    public Main() {
        // Settings need to come first because other classes depend on it.
        settings = new ApplicationSettings();
        settings.readDataFromSettingsFile();
        
        f = new Frame(this);
        fileController = new FileController(this);
    }

    public static void main(String[] args) {
        /*Can fix display issues with mac.
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        }catch (Exception e)
        {
            e.printStackTrace();
        }*/
        
        final Main mainController = new Main();
    }
    
    public FileController getFileController() {
        return fileController;
    }
    
    public JFrame getFrame() {
        return f;
    }
    
    public ApplicationSettings getSettings() {
        return settings;
    }
}
