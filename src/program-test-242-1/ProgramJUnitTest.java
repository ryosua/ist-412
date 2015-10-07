import controller.FileFilter;
import controller.Main;
import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;

public class ProgramJUnitTest
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
    public void fileFilterAcceptsJavaFiles() {
        File javaFileDir = new File(main.getSettings().getTestCaseDirectory().getAbsolutePath());
        FileFilter fileFilter = new FileFilter();
        assertTrue(fileFilter.accept(javaFileDir, "SomeClass.java"));
    }
    
    @Test
    public void fileFilterRejectsNonJavaFiles() {
        File javaFileDir = new File(main.getSettings().getTestCaseDirectory().getAbsolutePath());
        FileFilter fileFilter = new FileFilter();
        assertFalse(fileFilter.accept(javaFileDir, "SomeClass.txt"));
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