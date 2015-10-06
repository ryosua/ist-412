package controller;


import java.io.*;
import java.util.*;
import model.ApplicationSettings;
import model.Results;

public class BatchTester implements ProgramTester {

    private ApplicationSettings settings;
    
    public BatchTester(ApplicationSettings settings) {
        this.settings = settings;
    }

    @Override
    public void run() {
        //  initialize student and class configuration data
        int studentNumber = 0;
        String studentName = "blank";
        String studentHandle = "000000";
        String className = "242-1/";

        File path = settings.getJavaVersionDirectory();
        //  set fixed paths and file names:
        File sourcePath = settings.getSourceFileDirectory();
        File testDataPath = settings.getTestCaseDirectory();
        String argsFileName = testDataPath + "/args.txt";
        String testInputFileName = testDataPath + "/TestInput.txt";
        /*  make sure set correctly
         System.out.println("path: " + path);
         System.out.println("sourcePath: " + sourcePath);
         System.out.println("testDataPath: " + testDataPath);
         System.out.println("argsFileName: " + argsFileName);
         System.out.println("testInputFileName: " + testInputFileName);
         */
        try {
            //    config file has list of ordinal student number,
            //    student name, and random handle
            File configFile = settings.getConfigFile();
            Scanner in = new Scanner(configFile);
            int runNumber = 1;
            
            // Keep track of the output files, so we can generate a file for all
            // the results, for every test.
            Results results = new Results();
            ResultsController resultsController = new ResultsController(settings, results);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                Scanner inLine = new Scanner(line);
                //      debug code - print out scanned config info
                //      System.out.print("scanned config info: ");
                while (inLine.hasNext()) {
                    studentNumber = inLine.nextInt();
                    studentName = inLine.next();
                    studentHandle = inLine.next();
                }

                //      set paths and file names:
                String classPath = settings.getRootDirectory().getAbsolutePath() + "/bin/" + className + studentName;
                String studentPath = sourcePath + "/" + studentName;
                String inputFileStub = studentPath + "/input";
                String outputFileName = studentPath + "/output-" + studentName + ".txt";
                /*      make sure set correctly
                 System.out.println("classPath: " + classPath);
                 System.out.println("studentPath: " + studentPath);
                 System.out.println("inputFileStub: " + inputFileStub);
                 System.out.println("outputFileName: " + outputFileName);
                 */

                System.out.println("run #: " + runNumber + " ; studentNumber: " + studentNumber
                        + "; Name: " + studentName + "; Handle: " + studentHandle);
                System.out.println("Output goes to: " + outputFileName);

                //      run javac compiler - returns 0 on success
                //      Compiler Constructor:
                //      public Compiler(int numbr, String nme, String hndl, String pth, String clsPath, 
                //      String srcPath, String stdPath, String outFileName)
                Compiler c = new Compiler(runNumber, studentName, studentHandle, path.getAbsolutePath(), classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, results);
                int success = c.compileJava();

                //      Print whether or not compile successful
                if (success == 0) {
                    System.out.println("Compiled Successfully");
                } else {
                    System.out.println("Compile Exception");
                }

                //      Run the test cases
                //      TestRunner consructor:
                //      public TestRunner(int numbr, String nme, String hndl, String pth, String clsPath, 
                //      String srcPath, String stdPath, String tstDataPath, String argFileName, 
                //      String tstInputFileName, String inputFileStub, String outFileName)
                TestRunner r = new TestRunner(runNumber, studentName, studentHandle, path.getAbsolutePath(), classPath, sourcePath.getAbsolutePath(), studentPath, testDataPath.getAbsolutePath(), argsFileName, testInputFileName, inputFileStub, outputFileName);
                r.runJava();
                runNumber++;
                System.out.println();
                
                System.out.println(results.toString());
                resultsController.writeResults();
            }
        } catch (IOException ioe) {
            System.out.println("main IOException");
        }
    }

    public static void main(String[] args) {
        final Main main = new Main();
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
    }
}
