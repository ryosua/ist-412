package test;

import controller.FileFilter;
import controller.Main;
import java.io.File;
import model.Strings;
import org.junit.*;
import static org.junit.Assert.*;

public class FileFilterTest
{
    private Main main;
    private File testSettingsFile;
    
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        testSettingsFile = new File(Strings.TEST_SETTINGS_FILE_NAME);
        main = new Main(testSettingsFile);
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
        testSettingsFile.delete();
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
}