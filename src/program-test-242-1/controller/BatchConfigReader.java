package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.ApplicationSettings;
import model.Results;
import model.Student;

public class BatchConfigReader {
    
    private final Results results;
    private final ApplicationSettings settings;
    
    public BatchConfigReader(Results results, ApplicationSettings settings) {
        this.results = results;
        this.settings = settings;
    }
    
    public ArrayList<Student> readStudentsFromConfig() {
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

                Student student = new Student(path.getAbsolutePath(), classPath, sourcePath.getAbsolutePath(), studentPath, outputFileName, results, inputFileStub, studentName);
                students.add(student);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
