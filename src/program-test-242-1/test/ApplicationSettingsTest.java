package test;

import controller.ApplicationSettingsController;
import controller.Main;
import java.io.File;
import model.ApplicationSettings;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationSettingsTest {
    private Main main;
    
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        main = new Main();
    }
    
    @Test
    public void byDefaultSettingsAreEmptyFiles() {
        File emptyFile = new File("");
        ApplicationSettings settings = new ApplicationSettings();
        assertTrue(settings.getConfigFile().equals(emptyFile));
        //ect
    }
    
    @Test
    public void configFileReadAndWrite() {
        ApplicationSettings settings = new ApplicationSettings();
        File testFile = new File("testConfig.txt");
        settings.setConfigFile(testFile);
        ApplicationSettingsController.writeDataToSettingsFile(settings);
        ApplicationSettings newSettings = new ApplicationSettings();
        ApplicationSettingsController.readDataFromSettingsFile(settings);
        assertTrue(settings.getConfigFile().equals(newSettings.getConfigFile()));
    }
    
    @Test
    public void javaVersionDirectoryReadAndWrite() {
        
    }
    
    @Test
    public void outputFileDirectoryReadAndWrite() {
        
    }
    
    @Test
    public void rootDirectoryReadAndWrite() {
        
    }
    
    @Test
    public void runModeReadAndWrite() {
        
    }
    
    @Test
    public void sourceFileDirectoryReadAndWrite() {
        
    }
    
    @Test
    public void testCaseDirectoryReadAndWrite() {
        
    }
    
    @Test
    public void displayOutputCheckReadAndWrite() {
        
    }
    
    @Test
    public void testToString() {
        
    }
    
    @After
    public void teardownTest() {
        System.out.println("Test Finished");
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
}
