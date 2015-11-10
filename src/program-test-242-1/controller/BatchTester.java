package controller;

import java.io.*;
import java.util.*;
import model.ApplicationSettings;
import model.Results;
import model.Strings;
import model.Student;

public class BatchTester {

    private final ApplicationSettings settings;
    private final Results results;
    private final ResultsController resultsController;

    public BatchTester(ApplicationSettings settings) {
        this.settings = settings;

        // Keep track of the output files, so we can generate a file for all
        // the results, for every test.
        this.results = new Results();
        this.resultsController = new ResultsController(settings, results);
    }

    /**
     * Compiles, runs, and prints the results from all students.
     */
    public void run() {
        File testDataPath = settings.getTestCaseDirectory();
        String argsFileName = testDataPath + "/args.txt";
        String testInputFileName = testDataPath + "/TestInput.txt";

        // Get students from the Settings.
        ArrayList<Student> students = settings.getStudents();

        if (students != null) {
            for (Student student : students) {
                // Run javac compiler - returns 0 on success.
                Compiler c = new Compiler(student);
                int success = c.compileJava();

                // Print whether or not compile successful
                if (success == 0) {
                    System.out.println(student.getStudentName() + " compiled Successfully");
                } else {
                    System.out.println(student.getStudentName() + " compile Exception");
                }

                TestRunner r = new TestRunner(student.getPath(), student.getClassPath(), student.getStudentPath(), argsFileName, testInputFileName, student.getInputFileStub(), student.getOutputFileName());
                r.runJava();
            }

            resultsController.writeResults();

            System.out.println("Batch Tester finished.");
        } else {
            System.out.println("You must choose students before running the program.");
        }
    }

    public static void main(String[] args) {
        File settingsFile = new File(Strings.SETTINGS_FILE_NAME);
        final Main main = new Main(settingsFile);
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
    }
}
