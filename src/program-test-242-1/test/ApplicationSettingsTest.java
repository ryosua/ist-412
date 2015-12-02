package test;

import controller.ApplicationSettingsController;
import controller.Main;
import java.io.File;
import java.io.IOException;
import model.ApplicationSettings;
import model.Strings;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationSettingsTest {

    private static File testConfigFile;
    private static boolean testDisplayOutputCheck;
    private static File testJavaDir;
    private static File testOutputFile;
    private static File testRootDir;
    private static File testSourceFileDir;
    private static File testTestCaseDir;

    private Main main;
    private File testSettingsFile;

    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");
    }

    @Before
    public void setupTest() {
        testSettingsFile = new File(Strings.TEST_SETTINGS_FILE_NAME);
        main = new Main(testSettingsFile);

        testConfigFile = new File("testConfig.txt");
        testDisplayOutputCheck = false;
        testJavaDir = new File("testJavaDir");
        testOutputFile = new File("testOutputFile");
        testRootDir = new File("testRootDir");
        testSourceFileDir = new File("testSourceDir");
        testTestCaseDir = new File("testTestCaseDir");
    }

    @Test
    public void byDefaultSettingsAreSetToTheDefaultFile() {
        File defaultFile = new File("");
        File defaultOutputFile = new File("testResults.txt");
        assertTrue(main.getSettings().getConfigFile().equals(defaultFile));
        assertTrue(main.getSettings().getOutputFileDirectory().equals(defaultOutputFile));
        assertTrue(main.getSettings().getRootDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getSourceFileDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getTestCaseDirectory().equals(defaultFile));
    }

    @Test
    public void configFileReadAndWrite() {
        // Write to settings.
        try {
            testConfigFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setConfigFile(testConfigFile);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getConfigFile().equals(newSettings.getConfigFile()));
    }

    @Test
    public void outputFileDirectoryReadAndWrite() {
        // Write to settings.
        try {
            testOutputFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setOutputFileDirectory(testOutputFile);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getOutputFileDirectory().equals(newSettings.getOutputFileDirectory()));
    }

    @Test
    public void rootDirectoryReadAndWrite() {
        // Write to settings.
        try {
            testRootDir.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setRootDirectory(testRootDir);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getRootDirectory().equals(newSettings.getRootDirectory()));
    }

    @Test
    public void sourceFileDirectoryReadAndWrite() {
        // Write to settings.
        try {
            testSourceFileDir.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setSourceFileDirectory(testSourceFileDir);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getSourceFileDirectory().equals(newSettings.getSourceFileDirectory()));
    }

    @Test
    public void testCaseDirectoryReadAndWrite() {
        // Write to settings.
        try {
            testTestCaseDir.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setTestCaseDirectory(testTestCaseDir);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getTestCaseDirectory().equals(newSettings.getTestCaseDirectory()));
    }

    @Test
    public void displayOutputCheckReadAndWrite() {
        // Write to settings.       
        main.getSettings().setDisplayOutputCheck(testDisplayOutputCheck);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());

        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);

        assertTrue(main.getSettings().getDisplayOutputCheck() == newSettings.getDisplayOutputCheck());
    }

    @After
    public void teardownTest() {
        System.out.println("Test Finished");
        // Delete all the files and dirs created for testing.
        testConfigFile.delete();
        testJavaDir.delete();
        testOutputFile.delete();
        testRootDir.delete();
        testSourceFileDir.delete();
        testTestCaseDir.delete();
        
        // Delete the test settings file.
        testSettingsFile.delete();
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }

}
