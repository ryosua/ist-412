package test;

import controller.StudentReader;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentReaderTest {
    private Main main;
    private File testFile;
    private File savedConfigFile;
       
    @BeforeClass
    public static void setUpClass() {
    }
       
    @Before
    public void setUp() {
        System.out.println("Setup Tests.");
        main = new Main();
        testFile = new File("junitTestBatchConfigFile.txt");
        
        // Save the config file.
        savedConfigFile = main.getSettings().getConfigFile();
        
        //Set config to the test file.
        main.getSettings().setConfigFile(testFile);
    }
   
    @Test
    public void readStudentsFromConfig() {
        System.out.println("writeResults");
               
        // Create a test file to add to the results.
        PrintWriter out = null;
        try {
            testFile.createNewFile();
            out = new PrintWriter(testFile);
            out.println("000	mudgettdr	0000000");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
           
        Results results = new Results();
        
        //Create some students.
        ArrayList<Student> expectedStudents = new ArrayList();
        Student expectedStudent = new Student(
                main.getSettings().getJavaVersionDirectory().getAbsolutePath(),
                main.getSettings().getRootDirectory().getAbsolutePath() + "/bin/242-1/mudgettdr",
                main.getSettings().getSourceFileDirectory().getAbsolutePath(),
                main.getSettings().getSourceFileDirectory().getAbsolutePath() + "/mudgettdr",
                main.getSettings().getSourceFileDirectory().getAbsolutePath() + "/mudgettdr/output-mudgettdr.txt",
                results,
                main.getSettings().getSourceFileDirectory().getAbsolutePath() + "/mudgettdr/input",
                "mudgettdr"
        );
        expectedStudents.add(expectedStudent);
        
        // Read students from the test file using StudentReader.
        StudentReader reader = new StudentReader(results, main.getSettings());
        ArrayList<Student> readStudents = reader.readStudentsFromConfig();
        
        boolean studentsAreEqual = expectedStudents.equals(readStudents);
         
        assertTrue("The students were not read correctly from config file",
            studentsAreEqual);
    }
    
    @Test
    public void readStudentsFromFileStructure() {
        fail("We have not yet written a test for this method.");
    }
        
    @After
    public void tearDown() {
        System.out.println("Teardown Tests.");
        testFile.delete();
        
        //Set config back.
        main.getSettings().setConfigFile(savedConfigFile);
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }

    private void BatchConfigReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}