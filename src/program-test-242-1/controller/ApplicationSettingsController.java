package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.ApplicationSettings;

public class ApplicationSettingsController {

    
    public static void writeDataToSettingsFile(ApplicationSettings settings) {
        try (PrintWriter out = new PrintWriter(settings.getSettingsFile())) {

            if (settings.getConfigFile() != null) {
                out.println("Config File: " + settings.getConfigFile().getPath());
            }

            if (settings.getJavaVersionDirectory() != null) {
                out.println("Java Version Directory: " + settings.getJavaVersionDirectory().getPath());
            }

            if (settings.getOutputFileDirectory() != null) {
                out.println("Output File Directory: " + settings.getOutputFileDirectory().getPath());
            }

            if (settings.getRootDirectory() != null) {
                out.println("Root Directory: " + settings.getRootDirectory().getPath());
            }

            if (settings.getRunMode() != null) {
                out.println("Run mode: " + settings.getRunMode());
            }

            if (settings.getSourceFileDirectory() != null) {
                out.println("Source File Directory: " + settings.getSourceFileDirectory().getPath());
            }

            if (settings.getTestCaseDirectory() != null) {
                out.println("Test Case Directory: " + settings.getTestCaseDirectory().getPath());
            }

            out.println("Display Output: " + String.valueOf(settings.getDisplayOutputCheck()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readDataFromSettingsFile(ApplicationSettings settings) {
        Scanner inFile = null;
        try {
            // Create a new settings file if it does not exsit.
            settings.getSettingsFile().createNewFile();
            
            inFile = new Scanner(settings.getSettingsFile());

            while(inFile.hasNextLine()){
                String setting = inFile.nextLine();
                
                if(setting.startsWith("Config File: ")) {
                    settings.setConfigFile(new File(setting.substring("Config File: ".length())));
                }
                if(setting.startsWith("Output File Directory: ")){
                    settings.setOutputFileDirectory(new File(setting.substring("Output File Directory: ".length())));
                }
                if(setting.startsWith("Root Directory: ")){
                    settings.setRootDirectory(new File(setting.substring("Root Directory: ".length())));
                }
                if(setting.startsWith("Run mode: ")){
                    settings.setRunMode(new String(setting.substring("Run Mode: ".length())));
                }
                if(setting.startsWith("Source File Directory: ")){
                    settings.setSourceFileDirectory(new File(setting.substring("Source File Directory: ".length())));
                }
                if(setting.startsWith("Test Case Directory: ")){
                    settings.setTestCaseDirectory(new File(setting.substring("Test Case Directory: ".length())));
                }
                if(setting.startsWith("Java Version Directory: ")){
                    settings.setJavaVersionDirectory(new File(setting.substring("Java Version Directory: ".length())));
                } 
                if(setting.startsWith("Display Output: ")){
                    settings.setDisplayOutputCheck(Boolean.valueOf(setting.substring("Display Output: ".length())));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            inFile.close();
        }
    }

}
