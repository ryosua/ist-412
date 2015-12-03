package model;

import controller.ApplicationSettingsController;
import java.io.File;
import java.util.ArrayList;

public class ApplicationSettings {

    public final static String SINGLE_MODE = "Single Mode";
    public final static String BATCH_MODE = "Batch Mode";

    private final File settingsFile;
    private final File tutorialDirectory = new File("tutorial");
    private final File tutorialTextDirectory = new File(tutorialDirectory + "/tutorial.txt");
    private final File tutorialImageDirectory = new File(tutorialDirectory + "/tutorialImages");

    private File configFile = new File(""); // Just single for now.
    private File outputFileDirectory = new File("testResults.txt");
    private File rootDirectory = new File("");
    private File sourceFileDirectory = new File("");
    private File testCaseDirectory = new File("");

    private ArrayList<Student> students = null;

    private boolean displayOutputCheck = true;

    public ApplicationSettings(File settingsFile) {
        this.settingsFile = settingsFile;
    }

    public File getConfigFile() {
        return configFile;
    }

    public File getOutputFileDirectory() {
        return outputFileDirectory;
    }

    public File getRootDirectory() {
        return rootDirectory;
    }

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
    }

    public boolean getDisplayOutputCheck() {
        return displayOutputCheck;
    }

    public File getSettingsFile() {
        return settingsFile;
    }

    public File getTutorialTextDirectory() {
        return tutorialTextDirectory;
    }

    public File getTutorialDirectory() {
        return tutorialDirectory;
    }

    public File getTutorialImageDirectory() {
        return tutorialImageDirectory;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setConfigFile(File file) {
        configFile = file;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setOutputFileDirectory(File directory) {
        outputFileDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setRootDirectory(File directory) {
        this.rootDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setSourceFileDirectory(File directory) {
        sourceFileDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setTestCaseDirectory(File directory) {
        testCaseDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setDisplayOutputCheck(boolean value) {
        displayOutputCheck = value;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        String string = "Settings: \n\n";

        string += Strings.CONFIG_FILE_TAG + configFile.getAbsolutePath() + "\n";
        string += Strings.OUTPUT_FILE_TAG + outputFileDirectory.getAbsolutePath() + "\n";
        string += Strings.ROOT_DIRECTORY_TAG + rootDirectory.getAbsolutePath() + "\n";
        string += Strings.SOURCE_DIRECTORY_TAG + sourceFileDirectory.getAbsolutePath() + "\n";
        string += Strings.TEST_CASE_DIRECTORY_TAG + testCaseDirectory.getAbsolutePath() + "\n";
        string += Strings.DISPLAY_OUTPUT_TAG + displayOutputCheck + "\n";
        string += "Tutorial text directory: " + tutorialTextDirectory.getAbsolutePath() + "\n";
        string += "Tutorial image directory: " + tutorialImageDirectory.getAbsolutePath() + "\n";
        string += "Tutorial directory: " + tutorialDirectory.getAbsolutePath() + "\n";
        return string;
    }
}
