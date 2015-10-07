package model;

import java.io.File;
import java.util.HashSet;

/**
 * Represents the results of a Single or Batch test.
 */
public class Results {
    private final HashSet<File> files;
    
    public Results() {
        files = new HashSet<>();
    }
    
    public void addFile(File file) {
        files.add(file);
    }
    
    public HashSet<File> getFiles() {
        return files;
    }
    
    @Override
    public String toString() {
        String s = "Results: \n\n";
        
        for(File file: files) {
            s += file.getPath() + "\n";
        }
        
        return s;
    }
}
