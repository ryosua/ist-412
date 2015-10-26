package test;

import controller.Main;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");
    }

    @Before
    public void setupTest() {
        
    }
    
    @Test
    public void fileChooserIsNotNull() {
        Main main = new Main();
        assertNotNull(main.getFileChooser());
    }
    
    @Test
    public void frameIsNotNull() {
        Main main = new Main();
        main.openFrame();
        assertNotNull(main.getFrame());
    }
    
    @Test
    public void settingsIsNotNull() {
        Main main = new Main();
        assertNotNull(main.getSettings());
    }
    
    @Test
    public void userControllerIsNotNull() {
        Main main = new Main();
        assertNotNull(main.getUserController());
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
