import controller.UserController;
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
    
    // Ryan's Tests *****************************************************
    @Test
    public void tooShortPasswordInvalid() {
        String password = "123";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertFalse(result);
    }
    
    @Test
    public void tooShortPasswordInvalid2() {
        String password = "123456789";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertFalse(result);
    }
    
    @Test
    public void rightSizePasswordValid() {
        String password = "1234567890";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertTrue(result);
    }
    
    @Test
    public void rightSizePasswordValid2() {
        String password = "123456789012345";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertTrue(result);
    }
    
    @Test
    public void rightSizePasswordValid3() {
        String password = "12345678901234567890";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertTrue(result);
    }
    
    @Test
    public void tooLongPasswordInvalid() {
        String password = "123456789012345678901";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertFalse(result);
    }
    
    @Test
    public void tooLongPasswordInvalid2() {
        String password = "1234567890123456789012345";
        UserController userController = new UserController();
        boolean result = userController.validPassword(password);
        assertFalse(result);
    }
    // End Ryan's Tests *****************************************************
  
    @After
    public void teardownTest() {
        System.out.println("Test Finished");
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
}