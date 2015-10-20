import controller.Main;
import controller.SingleTester;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class SingleTesterTest
{
    private Main main;
    private File savedConfigFile;
    
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        main = new Main();
        
        // Save the old config file.
        savedConfigFile = main.getSettings().getConfigFile();
        
        // Set the config file to batchConfig.txt
        File singleConfigFile = new File("/Users/ryosua/java" + "/src/program-test-242-1/configSingle.txt");
        main.getSettings().setConfigFile(singleConfigFile);
    }
   
    @Test
    public void theOutputContainsNoExceptionsAndFileIsNotEmpty() {
        // Run the program in single test mode.
        final SingleTester singleTest = new SingleTester(main.getSettings());
        singleTest.run();
        
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
                    System.out.println("Error found.");
                }
            }
           
        } catch (FileNotFoundException ex) {
            error = true;
            System.out.println("File exception.");
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
        System.out.println("Test Finished");
        // Set the old config file back.
        main.getSettings().setConfigFile(savedConfigFile);
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
}