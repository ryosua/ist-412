package controller;

import java.io.*;

public class FileFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        if (name.endsWith(".java")) {
            return true;
        } else {
            return false;
        }
    }
}
