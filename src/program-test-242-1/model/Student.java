package model;

public class Student {

    private final Results results;
    private final String path;
    private final String classPath;
    private final String sourcePath;
    private final String studentPath;
    private final String outputFileName;
    private final String inputFileStub;
    
    public Student(String path, String classPath, String sourcePath, String studentPath, String outputFileName, Results results, String inputFileStub) {
        this.results = results;
        this.path = path;
        this.classPath = classPath;
        this.sourcePath = sourcePath;
        this.studentPath = studentPath;
        this.outputFileName = outputFileName;
        this.inputFileStub = inputFileStub;
        
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
}
