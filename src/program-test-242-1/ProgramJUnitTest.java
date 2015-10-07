import org.junit.*;
import static org.junit.Assert.*;

public class ProgramJUnitTest
{
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");
    }
    
    @Before
    public void setupTest() {
       
    }
   
    @Test
    public void exampleTest() {
        fail("This is an example test that should fail.");
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