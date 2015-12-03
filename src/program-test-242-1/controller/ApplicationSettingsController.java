package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.ApplicationSettings;
import model.Strings;

public class ApplicationSettingsController {

    public static void writeDataToSettingsFile(ApplicationSettings settings) {
        try (PrintWriter out = new PrintWriter(settings.getSettingsFile())) {

            if (settings.getConfigFile() != null) {
                out.println(Strings.CONFIG_FILE_TAG + settings.getConfigFile().getPath());
            }

            if (settings.getOutputFileDirectory() != null) {
                out.println(Strings.OUTPUT_FILE_TAG + settings.getOutputFileDirectory().getPath());
            }

            if (settings.getRootDirectory() != null) {
                out.println(Strings.ROOT_DIRECTORY_TAG + settings.getRootDirectory().getPath());
            }

            if (settings.getSourceFileDirectory() != null) {
                out.println(Strings.SOURCE_DIRECTORY_TAG + settings.getSourceFileDirectory().getPath());
            }

            if (settings.getTestCaseDirectory() != null) {
                out.println(Strings.TEST_CASE_DIRECTORY_TAG + settings.getTestCaseDirectory().getPath());
            }

            out.println(Strings.DISPLAY_OUTPUT_TAG + String.valueOf(settings.getDisplayOutputCheck()));

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

            while (inFile.hasNextLine()) {
                String setting = inFile.nextLine();

                if (setting.startsWith(Strings.CONFIG_FILE_TAG)) {
                    settings.setConfigFile(new File(setting.substring(Strings.CONFIG_FILE_TAG.length())));
                }
                if (setting.startsWith(Strings.OUTPUT_FILE_TAG)) {
                    settings.setOutputFileDirectory(new File(setting.substring(Strings.OUTPUT_FILE_TAG.length())));
                }
                if (setting.startsWith(Strings.ROOT_DIRECTORY_TAG)) {
                    settings.setRootDirectory(new File(setting.substring(Strings.ROOT_DIRECTORY_TAG.length())));
                }
                if (setting.startsWith(Strings.SOURCE_DIRECTORY_TAG)) {
                    settings.setSourceFileDirectory(new File(setting.substring(Strings.SOURCE_DIRECTORY_TAG.length())));
                }
                if (setting.startsWith(Strings.TEST_CASE_DIRECTORY_TAG)) {
                    settings.setTestCaseDirectory(new File(setting.substring(Strings.TEST_CASE_DIRECTORY_TAG.length())));
                }
                if (setting.startsWith(Strings.DISPLAY_OUTPUT_TAG)) {
                    settings.setDisplayOutputCheck(Boolean.valueOf(setting.substring(Strings.DISPLAY_OUTPUT_TAG.length())));
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
