package model;

public class Student {

    private final Results results;
    private final String path;
    private final String classPath;
    private final String sourcePath;
    private final String studentPath;
    private final String outputFileName;
    
    public Student(String path, String classPath, String sourcePath, String studentPath, String outputFileName, Results results) {
        this.results = results;
        this.path = path;
        this.classPath = classPath;
        this.sourcePath = sourcePath;
        this.studentPath = studentPath;
        this.outputFileName = outputFileName;
        
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
}
