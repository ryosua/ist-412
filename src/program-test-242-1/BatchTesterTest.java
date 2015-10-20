import controller.BatchTester;
import controller.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class BatchTesterTest
{
    private Main main;
    private File savedConfigFile;
    private boolean savedDisplayOutputCheck;
    
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        main = new Main();
        
        // Save the old config file.
        savedConfigFile = main.getSettings().getConfigFile();
        
        // Save the old output check setting(we don't want windows popping for the test).
        savedDisplayOutputCheck = main.getSettings().getDisplayOutputCheck();
        
        // Set the config file to batchConfig.txt
        File batchConfigFile = new File("/Users/ryosua/java" + "/src/program-test-242-1/configBatch.txt");
        main.getSettings().setConfigFile(batchConfigFile);
        
        // Set the output check setting to false.
        main.getSettings().setDisplayOutputCheck(false);
    }
   
    @Test
    public void theOutputContainsNoExceptionsAndFileIsNotEmpty() {
        // Run the program in single test mode.
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
        
        // Check to see if the output contains any exceptions.
        Scanner in = null;
        boolean error = false;
        int numberOfLines = 0;
        
        try {
            in = new Scanner(main.getSettings().getOutputFileDirectory());
                
            while(in.hasNext()) {
                numberOfLines++;
                if (in.nextLine().toLowerCase().contains("error")) {
                    error = true;
                }
            }
           
        } catch (FileNotFoundException ex) {
            error = true;
        } finally {
            in.close();
        }
        
        if (numberOfLines == 0) {
            error = true;
            System.out.println("Output has 0 lines.");
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