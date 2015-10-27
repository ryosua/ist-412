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
            
                //      run javac compiler - returns 0 on success
                //      Compiler Constructor:
                //      public Compiler(int numbr, String nme, String hndl, String pth, String clsPath, 
                //      String srcPath, String stdPath, String outFileName)
                Compiler c = new Compiler(path.getAbsolutePath(), classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, results);
                int success = c.compileJava();

                //      Print whether or not compile successful
                if (success == 0) {
                    //System.out.println("Compiled Successfully");
                } else {
                    //System.out.println("Compile Exception");
                }

                //      Run the test cases
                //      TestRunner consructor:
                //      public TestRunner(int numbr, String nme, String hndl, String pth, String clsPath, 
                //      String srcPath, String stdPath, String tstDataPath, String argFileName, 
                //      String tstInputFileName, String inputFileStub, String outFileName)
                //    public TestRunner(String pth, String clsPath, String stdPath, String argFileName, String tstInputFileName, String inFileStub, String outFileName) {
                TestRunner r = new TestRunner(path.getAbsolutePath(), classPath, studentPath, argsFileName, testInputFileName, inputFileStub, outputFileName);
                r.runJava();
                runNumber++;
                //System.out.println();
                
                //System.out.println(results.toString());
                resultsController.writeResults();
            }
        } catch (IOException ioe) {
            System.out.println("main IOException");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Main main = new Main();
        final BatchTester batchTest = new BatchTester(main.getSettings());
        batchTest.run();
    }
}
