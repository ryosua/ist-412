package controller;

import view.FileChooser;
import javax.swing.JFrame;
import model.ApplicationSettings;
import view.Frame;

public class Main {

    private final FileChooser fileChooser;
    private final ApplicationSettings settings;
    private final UserController userController;

    private Frame f;

    public Main() {
        // Changing the order may cause null pointers.
        settings = new ApplicationSettings();
        settings.readDataFromSettingsFile();
        userController = new UserController();
        fileChooser = new FileChooser(this);
    }

    public static void main(String[] args) {
        final Main mainController = new Main();
        mainController.openFrame();
    }

    public void openFrame() {
        f = new Frame(this);
    }

    public FileChooser getFileChooser() {
        return fileChooser;
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
