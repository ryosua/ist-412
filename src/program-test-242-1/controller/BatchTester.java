package controller;

import java.io.*;
import java.util.*;
import model.ApplicationSettings;
import model.Results;
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
        
        //Read students from the config file.
        BatchConfigReader reader = new BatchConfigReader(results, settings);
        ArrayList<Student> students = reader.readStudentsFromConfig();
        
        for (Student student : students) {
            // Run javac compiler - returns 0 on success.
            Compiler c = new Compiler(student);
            int success = c.compileJava();

            // Print whether or not compile successful
            if (success == 0) {
                System.out.println("Compiled Successfully");
            } else {
                System.out.println("Compile Exception");
            }

            TestRunner r = new TestRunner(student.getPath(), student.getClassPath(), student.getStudentPath(), argsFileName, testInputFileName, student.getInputFileStub(), student.getOutputFileName());
            r.runJava();
        }

        resultsController.writeResults();
        
        System.out.println("Batch Tester finished.");
    }

    public static void main(String[] args) {
        final Main main = new Main();
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
    }
}


    /*
 ///////////////////////////////////////////////////////////////////////////
        
        This is sample code that will allow us to root through a directory and 
        pull the names from each. 
        This will give us the names for each student in the desired folder for 
        testing.
        
        public static void main(String... args) {
          File[] files = new File("C:/").listFiles();
          showFiles(files);
        }

public static void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            showFiles(file.listFiles()); // Calls same method again.
        } else {
            System.out.println("File: " + file.getName());
        }
    }
}
////////////////////////////////////////////////        
*/
