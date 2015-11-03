package model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Student {

    private final Results results;
    private final String path;
    private final String classPath;
    private final String sourcePath;
    private final String studentPath;
    private final String outputFileName;
    private final String inputFileStub;
    private final String studentName;

    public Student(String path, String classPath, String sourcePath, String studentPath, String outputFileName, Results results, String inputFileStub, String studentName) {
        this.results = results;
        this.path = path;
        this.classPath = classPath;
        this.sourcePath = sourcePath;
        this.studentPath = studentPath;
        this.outputFileName = outputFileName;
        this.inputFileStub = inputFileStub;
        this.studentName = studentName;

        System.out.println("path: " + path);
        System.out.println("classPath: " + classPath);
        System.out.println("sourcePath: " + sourcePath);
    }

    public Results getResults() {
        return results;
    }

    public String getPath() {
        return path;
    }

    public String getClassPath() {
        return classPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public String getStudentPath() {
        return studentPath;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getInputFileStub() {
        return inputFileStub;
    }
    
    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        String result = "";
        result += "results: " + results.toString() + "\n";
        result += "path: " + path + "\n";
        result += "classPath: " + classPath + "\n";
        result += "sourcePath: " + sourcePath + "\n";
        result += "studentPath: " + studentPath + "\n";
        result += "outputFileName: " + outputFileName + "\n";
        result += "inputFileStub: " + inputFileStub + "\n";

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Student otherStudent = (Student) obj;
        return getResults().equals(otherStudent.getResults())
                && getPath().equals(otherStudent.getPath())
                && getClassPath().equals(otherStudent.getClassPath())
                && getSourcePath().equals(otherStudent.getSourcePath())
                && getStudentPath().equals(otherStudent.getStudentPath())
                && getOutputFileName().equals(otherStudent.getOutputFileName())
                && getInputFileStub().equals(otherStudent.getInputFileStub())
                && getInputFileStub().equals(otherStudent.getStudentName());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                append(results).
                append(path).
                append(classPath).
                append(sourcePath).
                append(studentPath).
                append(outputFileName).
                append(inputFileStub).
                append(studentName).
                toHashCode();
    }
}
