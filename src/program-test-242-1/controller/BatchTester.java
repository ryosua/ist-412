package controller;

import java.io.*;
import java.util.*;
import model.ApplicationSettings;
import model.Results;
import model.Student;

public class BatchTester implements ProgramTester {

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
    @Override
    public void run() {
        File testDataPath = settings.getTestCaseDirectory();
        String argsFileName = testDataPath + "/args.txt";
        String testInputFileName = testDataPath + "/TestInput.txt";
        
        for (Student student : getStudentsFromConfig()) {
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
    }

    public static void main(String[] args) {
        final Main main = new Main();
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
    }

    private ArrayList<Student> getStudentsFromConfig() {
        ArrayList<Student> students = new ArrayList<>();

        //  initialize student and class configuration data
        int studentNumber = 0;
        String studentName = "blank";
        String studentHandle = "000000";
        String className = "242-1/";

        File path = settings.getJavaVersionDirectory();
        // Set fixed paths and file names:
        File sourcePath = settings.getSourceFileDirectory();

        try {
            // Config file has list of ordinal student number,
            // student name, and random handle
            File configFile = settings.getConfigFile();
            Scanner in = new Scanner(configFile);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                Scanner inLine = new Scanner(line);
                while (inLine.hasNext()) {
                    studentNumber = inLine.nextInt();
                    studentName = inLine.next();
                    studentHandle = inLine.next();
                }

                // Set paths and file names:
                String classPath = settings.getRootDirectory().getAbsolutePath() + "/bin/" + className + studentName;
                String studentPath = sourcePath + "/" + studentName;
                String inputFileStub = studentPath + "/input";
                String outputFileName = studentPath + "/output-" + studentName + ".txt";

                Student student = new Student(path.getAbsolutePath(), classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, results, inputFileStub);
                students.add(student);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return students;
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
