import controller.Main;
import org.junit.*;
import static org.junit.Assert.*;

public class FileControllerTest {
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
    public void fileChooserWorks() {
        fail();
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