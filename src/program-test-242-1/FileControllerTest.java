import controller.FileController;
import controller.Main;
import java.io.File;
import javax.swing.JFileChooser;
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
        FileController fileController = new FileController(main);
        System.out.println("Please choose a file from the file chooser.");
        File file = fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG);
        assertTrue(file != null);
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