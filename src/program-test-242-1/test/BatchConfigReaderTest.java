package test;

import controller.BatchConfigReader;
import controller.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Results;
import model.Student;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BatchConfigReaderTest {
    private Main main;
    private File testFile;
       
    @BeforeClass
    public static void setUpClass() {
    }
       
    @Before
    public void setUp() {
        System.out.println("Setup Tests.");
        main = new Main();
        testFile = new File("junitTestBatchConfigFile.txt");
        
        //Set config to the test file.
    }
   
    @Test
    public void studentsReadCorrectly() {
        System.out.println("writeResults");
               
        // Create a test file to add to the results.
        PrintWriter out = null;
        try {
            testFile.createNewFile();
            out = new PrintWriter(testFile);
            out.println("Line1");
            out.println("Line2");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
        
        boolean studentsAreEqual = false;
        
        Results results = new Results();
        
        //Create some students.
        ArrayList<Student> expectedStudents = new ArrayList();
        
        // Read students from the test file using BatchConfigReader.
        BatchConfigReader reader = new BatchConfigReader(results, main.getSettings());
        ArrayList<Student> readStudents = reader.readStudentsFromConfig();
        
        studentsAreEqual = expectedStudents.equals(readStudents);
        
        assertTrue("The students were not read correctly from config file",
            studentsAreEqual);
    }
    
    @After
    public void tearDown() {
        System.out.println("Teardown Tests.");
        testFile.delete();
        
        //Set config back.
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }

    private void BatchConfigReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
