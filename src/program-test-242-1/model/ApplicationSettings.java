package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationSettings {
    
    private File outputFileDirectory = new File("testResults.txt");
    private File sourceFileDirectory = null;
    private File testCaseDirectory = null;
    private File javaVersionDirectory = null;
    private String settingsFileName = "Settings.txt";
    
    public File getOutputFileDirectory() {
        return outputFileDirectory;
    }

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
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
	
    public void writeDataToSettingsFile(){
        try (PrintWriter out = new PrintWriter(settingsFileName)) {
            
            if(outputFileDirectory != null){
                out.println("Output File Directory: " + outputFileDirectory.toString());
            }
            
            if(sourceFileDirectory != null){
                out.println("Source File Directory: " + sourceFileDirectory.toString());
            }

            if(testCaseDirectory != null){
                out.println("Test Case Directory: " + testCaseDirectory.toString());
            }

            if(javaVersionDirectory != null){
                out.println("Java Version Directory: " + javaVersionDirectory.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromSettingsFile(){
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File(settingsFileName));

            while(inFile.hasNextLine()){
                String setting = inFile.nextLine();
                
                if(setting.startsWith("Output File Directory: ")){
                    outputFileDirectory = new File(setting.substring("Output File Directory: ".length()));
                }
                if(setting.startsWith("Source File Directory: ")){
                    sourceFileDirectory = new File(setting.substring("Source File Directory: ".length()));
                }
                else if(setting.startsWith("Test Case Directory: ")){
                    testCaseDirectory = new File(setting.substring("Test Case Directory: ".length()));
                }
                else if(setting.startsWith("Java Version Directory: ")){
                    javaVersionDirectory = new File(setting.substring("Java Version Directory: ".length()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            inFile.close();
        }
    }
    
    @Override
    public String toString() {
        String string = "Settings: \n\n";
        
        string += "Output file: " + outputFileDirectory + "\n";
        string += "Source file: " + sourceFileDirectory + "\n";
        string += "Test directory: " + testCaseDirectory + "\n";
        string += "Java directory: " + javaVersionDirectory + "\n";
                
        return string;
    }
}
