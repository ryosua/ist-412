/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApplicationSettings;

/**
 *
 * @author dos5385
 */
public class ApplicationSettingsController {
    
    
    public static void writeDataToSettingsFile(ApplicationSettings settings){
        settings.writeDataToSettingsFile();
    }
    
    public static void readDataFromSettingsFile(ApplicationSettings settings){
        settings.readDataFromSettingsFile();
    }
    
}
