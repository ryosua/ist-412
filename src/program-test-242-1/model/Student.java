package model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Student {
    
    private final String classPath;
    private final String sourcePath;
    private final String studentPath;
    private final String outputFileName;
    private final String inputFileStub;
    private final String studentName;
    
    private Results results;

    public Student(String classPath, String sourcePath, String studentPath, String outputFileName, String inputFileStub, String studentName) {
        this.classPath = classPath;
        this.sourcePath = sourcePath;
        this.studentPath = studentPath;
        this.outputFileName = outputFileName;
        this.inputFileStub = inputFileStub;
        this.studentName = studentName;
    }

    public Results getResults() {
        return results;
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
    
    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        String result = "";
        result += "results: " + results.toString() + "\n";
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
        return getClassPath().equals(otherStudent.getClassPath())
                && getSourcePath().equals(otherStudent.getSourcePath())
                && getStudentPath().equals(otherStudent.getStudentPath())
                && getOutputFileName().equals(otherStudent.getOutputFileName())
                && getInputFileStub().equals(otherStudent.getInputFileStub())
                && getStudentName().equals(otherStudent.getStudentName());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                append(classPath).
                append(sourcePath).
                append(studentPath).
                append(outputFileName).
                append(inputFileStub).
                append(studentName).
                toHashCode();
    }
}
