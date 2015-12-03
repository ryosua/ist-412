package controller;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.ApplicationSettings;
import model.Results;
import model.Strings;
import model.Student;
import view.InputPanel;

public class BatchTester {

    private final ApplicationSettings settings;
    private final Results results;
    private final ResultsController resultsController;

    /**
     * Could be null depending on which constructor is used.
     */
    private InputPanel inputPanel;

    /**
     * The main constructor used for the application.
     *
     * @param settings the settings
     * @param inputPanel the input panel
     */
    public BatchTester(ApplicationSettings settings, InputPanel inputPanel) {
        this.settings = settings;

        // Keep track of the output files, so we can generate a file for all
        // the results, for every test.
        this.inputPanel = inputPanel;
        this.results = new Results();
        this.resultsController = new ResultsController(settings, results);
    }

    /**
     * Use this constructor for testing only. inputPanel will be null.
     *
     * @param settings the settings
     */
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

        if (inputPanel != null) {
            inputPanel.setButtonsEnabled(false);
            inputPanel.getProgressBar().setMaximum(students.size());
        }

        if (students != null) {
            for (Student student : students) {
                // Add results to student.
                student.setResults(results);

                // Run javac compiler - returns 0 on success.
                Compiler c = new Compiler(student);
                int success = c.compileAllStudentJavaFiles();

                // Print whether or not compile successful
                if (success == 0) {
                    System.out.println(student.getStudentName() + " compiled Successfully");
                } else {
                    System.out.println(student.getStudentName() + " compile Exception");
                }

                TestRunner r = new TestRunner(student.getClassPath(), student.getStudentPath(), argsFileName, testInputFileName, student.getInputFileStub(), student.getOutputFileName());
                r.runJava();

                if (inputPanel != null) {
                    inputPanel.getProgressBar().setValue(inputPanel.getProgressBar().getValue() + 1);
                }
            }

            // Batch finished, reset the progress bar and enable the buttons.
            if (inputPanel != null) {
                inputPanel.getProgressBar().setValue(0);
                inputPanel.setButtonsEnabled(true);
            }

            resultsController.writeResults();

            System.out.println("Batch Tester finished.");
        } else {
            JOptionPane.showMessageDialog(null, "You must choose students before running the program.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        File settingsFile = new File(Strings.SETTINGS_FILE_NAME);
        final Main main = new Main(settingsFile);
        final BatchTester batchTest = new BatchTester(main.getSettings(), null);
        batchTest.run();
    }
}
