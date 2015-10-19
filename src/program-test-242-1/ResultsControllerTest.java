import controller.Main;
import controller.ResultsController;
import model.Results;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResultsControllerTest {
    private Main main;
    
    public ResultsControllerTest() {
        main = new Main();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Setup Tests.");
    }
    
    @After
    public void tearDown() {
        System.out.println("Teardown Tests.");
    }

    @Test
    public void testWriteResults() {
        System.out.println("writeResults");
        ResultsController instance = new ResultsController(main.getSettings(), new Results());
        boolean fileExists = false;
        if(main.getSettings().getOutputFileDirectory() == instance.getOutputFile()){
            System.out.println("Settings Output Location: " + main.getSettings().getOutputFileDirectory());
            System.out.println("Output File Location: " + instance.getOutputFile());
            fileExists = true;
        }else{
            fileExists = false;
        }
        
        assertTrue(fileExists);
    }
    
}
