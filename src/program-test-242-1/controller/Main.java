package controller;

import javax.swing.JFrame;
import model.ApplicationSettings;
import view.Frame;

public class Main {

    private final Frame f;
    private final FileController fileController;
    private final ApplicationSettings settings;
    
    public Main() {
        f = new Frame(this);
        fileController = new FileController(this);
        settings = new ApplicationSettings();
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
