package controller;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

public class TestRunner {

    private String path;
    private String classPath;
    private String studentPath;
    private String argsFileName;
    private String testInputFileName;
    private String inputFileStub;
    private String inputFileName;
    private String outputFileName;
    private int success;

    public TestRunner(String pth, String clsPath, String stdPath, String argFileName, String tstInputFileName, String inFileStub, String outFileName) {

        path = pth;
        classPath = clsPath;
        studentPath = stdPath;
        argsFileName = argFileName;
        testInputFileName = tstInputFileName;
        inputFileStub = inFileStub;
        outputFileName = outFileName;
        success = 1;  // Outcome of compilation, success = 0
    }

    public void runJava() {

        try {
//    set up input files
//    TestInput.txt has inputs for each test on a single line
            File testInputFile = new File(testInputFileName);
            Scanner testInputs = new Scanner(testInputFile);
//    input.txt has inputs for a single run each on a separate line
//    and is created immediately before each test run from TestInput.txt

//    instantiate output file    
            File outputFile = new File(outputFileName);

//    instantiate command-line arguments file
            File argsFile = new File(argsFileName);

//    instantiate argument Scanner
            Scanner argsInput = new Scanner(argsFile);
            int run = 0;

            synchronized (outputFile) {
                while (argsInput.hasNextLine()) {
                    run++;
//        declare arg ArrayList for java ProcessBuilder
                    List<String> arg = new ArrayList<String>();
                    String argsLine = argsInput.nextLine();
//        parse argsLine via TestTools.parseLine
                    arg = TestTools.parseLine(argsLine);
                    arg.add(0, "java");

//        scan TestInput.txt
                    String testInputLine = testInputs.nextLine();

//        create input file for current run
                    List<String> inputs = new ArrayList<String>();
                    inputs = TestTools.parseLine(testInputLine);
                    inputFileName = inputFileStub + run + ".txt";
                    PrintWriter writeTests = new PrintWriter(inputFileName);
                    for (String element : inputs) {
                        writeTests.println(element);
                    }
                    writeTests.close();
                    File inputFile = new File(inputFileName);

//        create new java ProcessBuilder using arg ArrayList
                    ProcessBuilder pb = new ProcessBuilder(arg);

//        Create environment map and set environmental variables 
                    Map<String, String> env = pb.environment();
                    env.clear();
                    env.put("PATH", path);
                    env.put("CLASSPATH", classPath);

//        Determine current working directory
                    File cwd = pb.directory();
//        NB - ProcessBuilder default is to return a null  
//        pointer for the abstract path to indicate that it 
//        is using System.Properties "user.dir", i.e., the 
//        current system working directory; hence the
//        critical need to handle a NullPointerException.
//        Also returns a null pointer if the directory
//        doesn't exist.

//        compute new abstract working directory path = studentPath
                    File nwd = TestTools.cd(cwd, studentPath);

                    
//        set ProcessBuilder working directory to new abstract path
                    pb.directory(nwd);
//        System.out.println("new working directory: "  + pb.directory().getAbsolutePath()); 

//        redirect standard input, error, and output files; print process arguments      
                    pb.redirectInput(Redirect.from(inputFile));
                    pb.redirectErrorStream(true);
                    pb.redirectOutput(Redirect.appendTo(outputFile));

//        start java process    
                    Process p = pb.start();

//        want processes to run sequentially to keep output in order         
//        basically joins thread to process to force sequential execution
//        need to be careful - if any process hangs, whole run hangs
                    p.waitFor();


                    assert pb.redirectInput() == Redirect.PIPE;
                    assert pb.redirectOutput().file() == outputFile;
                    assert p.getInputStream().read() == -1;
                    
                }
                return;
            }
        } catch (java.lang.IllegalThreadStateException itse) {
            itse.printStackTrace();
        } catch (java.util.NoSuchElementException nsee) {
            nsee.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
    }
}
