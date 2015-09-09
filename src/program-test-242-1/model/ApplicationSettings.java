package model;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationSettings {

    private File sourceFileDirectory = null;
    private File testCaseDirectory = null;
	private File javaVersionDirectory = null;
	private String settingsFileName = "Settings.txt";

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
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
		PrintWriter out = new PrintWriter(settingsFileName);
		
		if(sourceFileDirectory != null){
			out.println("Source File Directory: " + sourceFileDirectory.toString());
		}
		
		if(testCaseDirectory != null){
			out.println("Test Case Directory: " + testCaseDirectory.toString());
		}
		
		if(javaVersionDirectory != null){
			out.println("Java Version Directory: " + javaVersionDirectory.toString());
		}
		
		out.close();
	}
	
	public void readDataFromSettingsFile(){
		
		Scanner inFile = new Scanner(new File(settingsFileName));
		
		while(inFile.hasNextLine()){
			String setting = inFile.nextLine();
			
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
	}
}
