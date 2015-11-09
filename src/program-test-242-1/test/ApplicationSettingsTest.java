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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationSettingsTest {

    private static File testConfigFile;
    private static File testJavaDir;
    private static File testOutputFile;
    private static File testRootDir;

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
        testJavaDir = new File("testJavaDir");
        testOutputFile = new File("testOutputFile");
        testRootDir = new File("testRootDir");
    }

    @Test
    public void byDefaultSettingsAreSetToTheDefaultFile() {
        File defaultFile = new File("");
        assertTrue(main.getSettings().getConfigFile().equals(defaultFile));
        assertTrue(main.getSettings().getJavaVersionDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getOutputFileDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getRootDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getSourceFileDirectory().equals(defaultFile));
        assertTrue(main.getSettings().getTestCaseDirectory().equals(defaultFile));
    }

    @Test
    public void configFileReadAndWrite() {
        writeToSettings(testConfigFile);
        
        // Read from settings.
        ApplicationSettings newSettings = new ApplicationSettings(testSettingsFile);
        ApplicationSettingsController.readDataFromSettingsFile(newSettings);
        
        assertTrue(main.getSettings().getConfigFile().equals(newSettings.getConfigFile()));
    }
       
    @Test
    public void javaVersionDirectoryReadAndWrite() {
        fail("Need to write this test.");
    }

    @Test
    public void outputFileDirectoryReadAndWrite() {
        fail("Need to write this test.");
    }

    @Test
    public void rootDirectoryReadAndWrite() {
        fail("Need to write this test.");
    }

    @Test
    public void sourceFileDirectoryReadAndWrite() {
        fail("Need to write this test.");
    }

    @Test
    public void testCaseDirectoryReadAndWrite() {
        fail("Need to write this test.");
    }

    @Test
    public void displayOutputCheckReadAndWrite() {
        fail("Need to write this test.");
    }

    @After
    public void teardownTest() {
        System.out.println("Test Finished");
        testConfigFile.delete();
        testJavaDir.delete();
        testOutputFile.delete();
        testRootDir.delete();
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
    
    private void writeToSettings(File fileToWrite) {
        try {
            fileToWrite.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        main.getSettings().setConfigFile(fileToWrite);
        ApplicationSettingsController.writeDataToSettingsFile(main.getSettings());
    }
}
