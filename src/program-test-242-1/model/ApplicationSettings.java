package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSettings {
    public final static String SINGLE_MODE = "Single Mode";
    public final static String BATCH_MODE = "Batch Mode";
   
    private final File settingsFile = new File("Settings.txt");
    
    private File configFile = new File("C:/java/src/program-test-242-1/configSingle.txt"); // Just single for now.
    private File javaVersionDirectory = new File("C:/java/jdk1.7.0_71/bin");
    private File outputFileDirectory = new File("C:/java/src/program-test-242-1/testResults.txt");
    private File sourceFileDirectory = new File("C:/java/src/program-test-242-1/src/src-output");
    private File testCaseDirectory = new File("C:/java/src/program-test-242-1/src");
    
    private String runMode = SINGLE_MODE;
    
    public String getRunMode() {
        return runMode;
    }
    
    public File getConfigFile() {
        return configFile;
    }
            
    public File getJavaVersionDirectory() {
        return javaVersionDirectory;
    }
    
    public File getOutputFileDirectory() {
        return outputFileDirectory;
    }

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
    }
    
    public void setConfigFile(File file) {
        configFile = file;
        writeDataToSettingsFile();
    }
    
    public void setJavaVersionDirectory(File directory) {
        javaVersionDirectory = directory;
        writeDataToSettingsFile();
    }
    
    public void setOutputFileDirectory(File directory) {
        outputFileDirectory = directory;
        writeDataToSettingsFile();
    }

    public void setSourceFileDirectory(File directory) {
        sourceFileDirectory = directory;
	writeDataToSettingsFile();
    }

    public void setTestCaseDirectory(File directory) {
        testCaseDirectory = directory;
        writeDataToSettingsFile();
    }
    
    public void setRunMode(String runMode) {
        this.runMode = runMode;
        writeDataToSettingsFile();
    }
	
    public void writeDataToSettingsFile(){
        try (PrintWriter out = new PrintWriter(settingsFile)) {
            
            if(configFile != null){
                out.println("Config File: " + configFile.getPath());
            }
            
            if(javaVersionDirectory != null){
                out.println("Java Version Directory: " + javaVersionDirectory.getPath());
            }
            
            if(outputFileDirectory != null){
                out.println("Output File Directory: " + outputFileDirectory.getPath());
            }
            
            if(sourceFileDirectory != null){
                out.println("Source File Directory: " + sourceFileDirectory.getPath());
            }

            if(testCaseDirectory != null){
                out.println("Test Case Directory: " + testCaseDirectory.getPath());
            }
            
            if(runMode != null) {
                out.println("Run mode: " + runMode);
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromSettingsFile(){
        Scanner inFile = null;
        try {
            // Create a new settings file if it does not exsit.
            settingsFile.createNewFile();
            
            inFile = new Scanner(settingsFile);

            while(inFile.hasNextLine()){
                String setting = inFile.nextLine();
                
                if(setting.startsWith("Config File: ")) {
                    configFile = new File(setting.substring("Config File: ".length()));
                }
                else if(setting.startsWith("Output File Directory: ")){
                    outputFileDirectory = new File(setting.substring("Output File Directory: ".length()));
                }
                else if(setting.startsWith("Source File Directory: ")){
                    sourceFileDirectory = new File(setting.substring("Source File Directory: ".length()));
                }
                else if(setting.startsWith("Test Case Directory: ")){
                    testCaseDirectory = new File(setting.substring("Test Case Directory: ".length()));
                }
                else if(setting.startsWith("Java Version Directory: ")){
                    javaVersionDirectory = new File(setting.substring("Java Version Directory: ".length()));
                } 
                else if(setting.startsWith("Run mode: ")){
                    runMode = new String(setting.substring("Run Mode: ".length()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationSettings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            inFile.close();
        }
    }
    
    @Override
    public String toString() {
        String string = "Settings: \n\n";
        
        string += "Config file: " + configFile.getAbsolutePath() + "\n";
        string += "Java directory: " + javaVersionDirectory.getAbsolutePath() + "\n";
        string += "Output file: " + outputFileDirectory.getAbsolutePath() + "\n";
        string += "Source file: " + sourceFileDirectory.getAbsolutePath() + "\n";
        string += "Test directory: " + testCaseDirectory.getAbsolutePath() + "\n";
        string += "Run mode: " + runMode + "\n";
       
        return string;
    }
}
