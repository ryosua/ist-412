package model;

import controller.ApplicationSettingsController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationSettings {
    public final static String SINGLE_MODE = "Single Mode";
    public final static String BATCH_MODE = "Batch Mode";
   
    private final File settingsFile = new File("Settings.txt");
    
    private File configFile = new File(""); // Just single for now.
    private File javaVersionDirectory = new File("");
    private File outputFileDirectory = new File("");
    private File rootDirectory = new File("");
    private File sourceFileDirectory = new File("");
    private File testCaseDirectory = new File("");
    private File tutorialTextDirectory = new File("");
    private File tutorialImageDirectory = new File("");
    
    private String runMode = SINGLE_MODE;
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
    
    public String getRunMode() {
        return runMode;
    }

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
    }
    
    public boolean getDisplayOutputCheck(){
        return displayOutputCheck;
    }

    public File getSettingsFile() {
        return settingsFile;
    }
    
    public File getTutorialTextDirectory(){
        return tutorialTextDirectory;
    }
    
    public File getTutorialImageDirectory(){
        return tutorialImageDirectory;
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
    
    public void setRunMode(String runMode) {
        this.runMode = runMode;
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
    
    public void setDisplayOutputCheck(boolean value){
        displayOutputCheck = value;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }
    
    public void setTutorialTextDirectory(File directory){
        tutorialTextDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }
    
    public void setTutorialImageDirectory(File directory){
        tutorialImageDirectory = directory;
        ApplicationSettingsController.writeDataToSettingsFile(this);
    }
    
    @Override
    public String toString() {
        String string = "Settings: \n\n";
        
        string += "Config file: " + configFile.getAbsolutePath() + "\n";
        string += "Java directory: " + javaVersionDirectory.getAbsolutePath() + "\n";
        string += "Output file: " + outputFileDirectory.getAbsolutePath() + "\n";
        string += "Root directory: " + rootDirectory.getAbsolutePath() + "\n";
        string += "Run mode: " + runMode + "\n";
        string += "Source file: " + sourceFileDirectory.getAbsolutePath() + "\n";
        string += "Test directory: " + testCaseDirectory.getAbsolutePath() + "\n";
        string += "Display Output: " + displayOutputCheck + "\n";
        string += "Tutorial text directory: " + tutorialTextDirectory + "\n";
        string += "Tutorial image directory: " + tutorialImageDirectory + "\n";
        return string;
    }
}
