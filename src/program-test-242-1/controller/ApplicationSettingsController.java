package controller;

import model.ApplicationSettings;

public class ApplicationSettingsController {

    public static void writeDataToSettingsFile(ApplicationSettings settings) {
        settings.writeDataToSettingsFile();
    }

    public static void readDataFromSettingsFile(ApplicationSettings settings) {
        settings.readDataFromSettingsFile();
    }

}
