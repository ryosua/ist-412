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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentReaderTest {

    private static Main main;
    private static File testFile;
    private static File savedConfigFile;
    private static File savedSourceDir;
    private static File testDir;
    private static File testSubDir;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setup Tests.");
        main = new Main();
        testFile = new File("junitTestBatchConfigFile.txt");

        // Save the settings files that will be modified for the test.
        savedConfigFile = main.getSettings().getConfigFile();
        savedSourceDir = main.getSettings().getSourceFileDirectory();

        //Set config to the test file.
        main.getSettings().setConfigFile(testFile);
    }

    @Before
    public void setUp() {
        
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
        Results results = new Results();

        // Create a test file structure.
        testDir = new File(main.getSettings().getSourceFileDirectory().getAbsolutePath() + "/testDir");
        testSubDir = new File(testDir.getAbsoluteFile() + "/mudgettdr");
        testDir.mkdirs();
        testSubDir.mkdirs();
        
        main.getSettings().setSourceFileDirectory(testDir);

        //Create some students.
        ArrayList<Student> expectedStudents = new ArrayList();
        Student expectedStudent = new Student(
                main.getSettings().getJavaVersionDirectory().getAbsolutePath(),
                main.getSettings().getRootDirectory().getAbsolutePath() + "/bin/mudgettdr",
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
        ArrayList<Student> readStudents = reader.readStudentsFromFileStructure();

        boolean studentsAreEqual = expectedStudents.equals(readStudents);

        assertTrue("The students were not read correctly from the file structure.",
                studentsAreEqual);
    }

    @After
    public void tearDown() {
        
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Teardown Tests.");
        
        testFile.delete();

        //Set settings back.
        main.getSettings().setConfigFile(savedConfigFile);
        main.getSettings().setSourceFileDirectory(savedSourceDir);
        
        testSubDir.delete();
        testDir.delete();
    }

    private void BatchConfigReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
