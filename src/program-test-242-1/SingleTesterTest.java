import controller.Main;
import controller.SingleTester;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

public class SingleTesterTest
{
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
                if (in.nextLine().toLowerCase().contains("exception")
                    || in.nextLine().toLowerCase().contains("error")) {
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
        }
         
        assertFalse(error);
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