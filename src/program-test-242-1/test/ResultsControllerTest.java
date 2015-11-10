package test;

import controller.Main;
import controller.ResultsController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Results;
import model.Strings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResultsControllerTest {

    private Main main;
    private File testFile;
    private File testSettingsFile;

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        System.out.println("Setup Tests.");
        testSettingsFile = new File(Strings.SETTINGS_FILE_NAME);
        main = new Main(testSettingsFile);
        testFile = new File("junitTestResultsFile.txt");
    }

    @Test
    public void testWriteResults() {
        System.out.println("writeResults");

        boolean error = false;

        // Create a test results object and add a file with some text on it.
        Results testResults = new Results();

        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Line1");
        expectedResults.add("Line2");

        // Create a test file to add to the results.
        PrintWriter out = null;
        try {
            testFile.createNewFile();
            out = new PrintWriter(testFile);
            for (String line: expectedResults) {
                out.println(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            error = true;
        } catch (IOException ex) {
            ex.printStackTrace();
            error = true;
        } finally {
            out.close();
        }

        // Add the test file to the results.
        testResults.addFile(testFile);

        ResultsController instance = new ResultsController(main.getSettings(), testResults);
        instance.writeResults();

        Scanner in = null;
        ArrayList<String> readResults = new ArrayList<>();
        
        // Make sure the file is there and the results written match what was written.
        try {
            in = new Scanner(main.getSettings().getOutputFileDirectory());
            
            while (in.hasNextLine() == true) {
                readResults.add(in.nextLine());
            }

        } catch (FileNotFoundException ex) {
            error = true;
        } finally {
            in.close();
        }
        
        // The results controller prints a new line at the end of each file.
        expectedResults.add("");
        
        //System.out.println("Expected results: " + expectedResults.toString());
        //System.out.println("Read results: " + readResults.toString());
               
        assertFalse("There was an error writing the results.", error);
        assertTrue("The expected results did not match the actual results.", expectedResults.equals(readResults));
    }

    @After
    public void tearDown() {
        System.out.println("Teardown Tests.");
        testFile.delete();
    }

    @AfterClass
    public static void tearDownClass() {

    }

}
