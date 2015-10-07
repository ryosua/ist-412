package controller;

import javax.swing.JFrame;
import model.ApplicationSettings;
import view.Frame;
import view.InputPanel;

public class Main {

    private final FileController fileController;
    private final ApplicationSettings settings;
    private final UserController userController;

    private Frame f;

    public Main() {
        // Changing the order may cause null pointers.
        settings = new ApplicationSettings();
        settings.readDataFromSettingsFile();
        userController = new UserController();
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
        mainController.openFrame();
    }

    public void openFrame() {
        f = new Frame(this);
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

    public UserController getUserController() {
        return userController;
    }
}
