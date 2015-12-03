package controller;

import java.io.File;
import view.FileChooser;
import javax.swing.JFrame;
import model.ApplicationSettings;
import model.Strings;
import view.Frame;

public class Main {

    private static final File settingsFile = new File(Strings.SETTINGS_FILE_NAME);
    private final FileChooser fileChooser;
    private final ApplicationSettings settings;

    private Frame f;

    public Main(File settingsFile) {
        // Changing the order may cause null pointers.
        settings = new ApplicationSettings(settingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(settings);
        fileChooser = new FileChooser(this);
    }

    public static void main(String[] args) {
        final Main mainController = new Main(settingsFile);
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
}
