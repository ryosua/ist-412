package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import model.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Compiler;
import controller.Main;
import model.ApplicationSettings;
import model.Results;
import model.Strings;
import static org.junit.Assert.assertEquals;

public class CompilerTest {

    private static Main main;
    private static File settingsFile;
    private static File testFailureDirectory;
    private static File testSourceDirectory;
    private static File testValidDirectory;
    private static File testValidJavaFile;
    private static File testBadJavaFile;

    @BeforeClass
    public static void setupTests() {
        try {
            System.out.println("Starting Tests");

            settingsFile = new File(Strings.SETTINGS_FILE_NAME);
            main = new Main(settingsFile);

            testSourceDirectory = new File("testSourceDir");
            testSourceDirectory.mkdir();

            testValidDirectory = new File(testSourceDirectory.getAbsolutePath() + "/testStudentSuccess");
            testValidDirectory.mkdir();
            testValidJavaFile = new File(testValidDirectory.getAbsolutePath() + "/testValidJavaFile.java");
            testValidJavaFile.createNewFile();

            // Write a valid java file that can be compiled.
            testFailureDirectory = new File(testSourceDirectory.getAbsolutePath() + "/testStudentFailure");
            testFailureDirectory.mkdir();
            testBadJavaFile = new File(testFailureDirectory.getAbsolutePath() + "/testBadJavaFile.java");
            testBadJavaFile.createNewFile();

            // Write a java file with errors that will not compile.
            PrintWriter badJavaWriter = new PrintWriter(testBadJavaFile);
            badJavaWriter.println("This is invalid java code.");
            badJavaWriter.close();

            // Write a java file with out errors that will compile.
            PrintWriter validJavaWriter = new PrintWriter(testValidJavaFile);
            validJavaWriter.println("public class testValidJavaFile{ public static void main(String []args){ System.out.println(\"Hello World\"); } }");
            validJavaWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Before
    public void setupTest() {

    }

    @Test
    public void compileSuccess() {
        ApplicationSettings settings = main.getSettings();
        // Set paths and file names:
        String studentName = "testStudentSuccess";
        File sourcePath = testSourceDirectory;
        String classPath = settings.getRootDirectory().getAbsolutePath() + "/bin/" + studentName;
        String studentPath = testValidDirectory.getAbsolutePath();
        String inputFileStub = studentPath + "/input";
        String outputFileName = studentPath + "/output-" + studentName + ".txt";

        Student student = new Student(classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, inputFileStub, studentName);
        
        // Create results just for testing purposes.
        student.setResults(new Results());
                
        Compiler compiler = new Compiler(student);
        int success = compiler.compileAllStudentJavaFiles();
        
        // Delete the output file.
        new File(outputFileName).delete();
        
        assertEquals("The compile failed.", 0, success);
    }

    @Test
    public void compileFailure() {
        ApplicationSettings settings = main.getSettings();
        // Set paths and file names:
        String studentName = "testStudentFailure";
        File sourcePath = testSourceDirectory;
        String classPath = settings.getRootDirectory().getAbsolutePath() + "/bin/" + studentName;
        String studentPath = testFailureDirectory.getAbsolutePath();
        String inputFileStub = studentPath + "/input";
        String outputFileName = studentPath + "/output-" + studentName + ".txt";

        Student student = new Student(classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, inputFileStub, studentName);
        
        // Create results just for testing purposes.
        student.setResults(new Results());
        
        Compiler compiler = new Compiler(student);
        int success = compiler.compileAllStudentJavaFiles();
        
        // Delete the output file.
        new File(outputFileName).delete();
        
        assertEquals("The compile succeeded when it should have failed.", 1, success);

    }

    @After
    public void teardownTest() {
        System.out.println("Test Finished");
    }

    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
        
        testValidJavaFile.delete();
        testBadJavaFile.delete();

        testValidDirectory.delete();
        testFailureDirectory.delete();

        testSourceDirectory.delete();
    }
}
