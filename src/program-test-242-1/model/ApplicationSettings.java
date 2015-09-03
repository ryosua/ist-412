package model;


import java.io.File;

public class ApplicationSettings {

    private File sourceFileDirectory = null;
    private File testCaseDirectory = null;

    public File getSourceFileDirectory() {
        return sourceFileDirectory;
    }

    public File getTestCaseDirectory() {
        return testCaseDirectory;
    }

    public void setSourceFileDirectory(File directory) {
        sourceFileDirectory = directory;
    }

    public void setTestCaseDirectory(File directory) {
        testCaseDirectory = directory;
    }
}
