package test;

import controller.BatchTester;
import controller.Main;
import controller.StudentReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Strings;
import org.junit.*;
import static org.junit.Assert.*;

public class BatchTesterTest
{
    private Main main;
    private File savedConfigFile;
    private boolean savedDisplayOutputCheck;
    private File settingsFile;
    
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        settingsFile = new File(Strings.SETTINGS_FILE_NAME);
        main = new Main(settingsFile);
        
        // Save the old config file.
        savedConfigFile = main.getSettings().getConfigFile();
        
        // Save the old output check setting(we don't want windows popping for the test).
        savedDisplayOutputCheck = main.getSettings().getDisplayOutputCheck();
        
        // Set the config file to batchConfig.txt
        File batchConfigFile = new File("/Users/ryosua/java" + "/src/program-test-242-1/configBatch.txt");
        main.getSettings().setConfigFile(batchConfigFile);
        
        // Set the output check setting to false.
        main.getSettings().setDisplayOutputCheck(false);
        
        // Read students and save to settings.
        StudentReader reader = new StudentReader(main.getSettings());
        main.getSettings().setStudents(reader.readStudentsFromFileStructure());
    }
   
    @Test
    public void theOutputFileIsNotEmpty() {
        // Run the program in single test mode.
        final BatchTester batchTest = new BatchTester(main.getSettings(), null);
        batchTest.run();
        
        // Check to see if the output contains any exceptions.
        Scanner in = null;
        boolean error = false;
        
        try {
            in = new Scanner(main.getSettings().getOutputFileDirectory());
            
            // Make sure the file is there and there is at least something written to it.
            if (in.hasNext() == false) {
                error = true;
            }
           
        } catch (FileNotFoundException ex) {
            error = true;
        } finally {
            in.close();
        }
        
        assertFalse(error);
    }
    
    @After
    public void teardownTest() {
        // Set the old settings back to what they were before the test.
        main.getSettings().setConfigFile(savedConfigFile);
        main.getSettings().setDisplayOutputCheck(savedDisplayOutputCheck);
        
        System.out.println("Test Finished");
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
}