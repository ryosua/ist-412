package model;

import controller.ApplicationSettingsController;
import java.io.File;
import java.util.ArrayList;

public class ApplicationSettings {

    public final static String SINGLE_MODE = "Single Mode";
    public final static String BATCH_MODE = "Batch Mode";

    private final File settingsFile = new File("Settings.txt");
    private final File tutorialDirectory = new File("tutorial");

    private File configFile = new File(""); // Just single for now.
    private File javaVersionDirectory = new File("");
    private File outputFileDirectory = new File("");
    private File rootDirectory = new File("");
    private File sourceFileDirectory = new File("");
    private File testCaseDirectory = new File("");
    private File tutorialTextDirectory = new File(tutorialDirectory + "/tutorial.txt");
    private File tutorialImageDirectory = new File(tutorialDirectory + "/tutorialImages");
    private ArrayList<Student> students = null;
    
   

    private boolean displayOutputCheck = true;

    public File getConfigFile() {
        return configFile;
    }

    public File getJavaVersionDirectory() {
        return javaVersionDirectory;
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
    
    public File getTutorialTextDirectory(){
        return tutorialTextDirectory;
    }
    
    public File getTutorialDirectory(){
        return tutorialDirectory;
    }
  
    public File getTutorialImageDirectory(){
        return tutorialImageDirectory;
    } 
    
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setConfigFile(File file) {
        configFile = file;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }

    public void setJavaVersionDirectory(File directory) {
        javaVersionDirectory = directory;
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

        string += "Config file: " + configFile.getAbsolutePath() + "\n";
        string += "Java directory: " + javaVersionDirectory.getAbsolutePath() + "\n";
        string += "Output file: " + outputFileDirectory.getAbsolutePath() + "\n";
        string += "Root directory: " + rootDirectory.getAbsolutePath() + "\n";
        string += "Source file: " + sourceFileDirectory.getAbsolutePath() + "\n";
        string += "Test directory: " + testCaseDirectory.getAbsolutePath() + "\n";
        string += "Display Output: " + displayOutputCheck + "\n";
        string += "Tutorial text directory: " + tutorialTextDirectory.getAbsolutePath() + "\n";
        string += "Tutorial image directory: " + tutorialImageDirectory.getAbsolutePath() + "\n";
        string += "Tutorial directory: " + tutorialDirectory.getAbsolutePath() + "\n";
        return string;
    }
}
