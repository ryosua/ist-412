package controller;

import java.io.*;
import java.util.*;

public class TestTools {

    /**
     * cd based on String path
     *
     * @param currentDir
     * @param destinationDir
     * @return
     */
    public static String cd(String currentDir, String destinationDir) {
        ProcessBuilder pb = new ProcessBuilder("cd", currentDir);
        pb.directory(new File(destinationDir));

        return pb.directory().getAbsolutePath();
    }

    /**
     * cd based on abstract File path
     *
     * @param cwd
     * @param destinationPath
     * @return
     */
    public static File cd(File cwd, String destinationPath) {
        String cwdPath;
        File nwd;
        String nwdPath;
        try {
            cwdPath = cwd.getAbsolutePath();
        } catch (NullPointerException npe) //  NB - ProcessBuilder default is to return a null  
        //  pointer for the abstract path to indicate that it 
        //  is using System.Properties "user.dir", i.e., the 
        //  current system working directory; hence the
        //  critical need to handle a NullPointerException.
        //  Also returns a null pointer if the directory
        //  doesn't exist. 
        {
            cwdPath = System.getProperty("user.dir");
            cwd = new File(cwdPath);
            cwdPath = cwd.getAbsolutePath();
        }

        try {
            nwd = new File(destinationPath);
            nwdPath = nwd.getAbsolutePath();
        } catch (NullPointerException npe) {
            nwd = cwd;
            nwdPath = nwd.getAbsolutePath();
        }

        return nwd;
    }

    /**
     * directory listing method
     *
     * @param cwd
     */
    public static void dir(File cwd) {
        String cwdPath;
        String[] directoryListing;
        try {
            cwdPath = cwd.getAbsolutePath();
            directoryListing = cwd.list();
            for (String element : directoryListing) {
                System.out.println(element);
            }
        } catch (NullPointerException npe) //  NB - ProcessBuilder default is to return a null  
        //  pointer for the abstract path to indicate that it 
        //  is using System.Properties "user.dir", i.e., the 
        //  current system working directory; hence the
        //  critical need to handle a NullPointerException.
        //  Also returns a null pointer if the directory
        //  doesn't exist.  
        {
            cwdPath = System.getProperty("user.dir");
            System.out.println("dir - current working directory null");
            cwd = new File(cwdPath);
            cwdPath = cwd.getAbsolutePath();
            directoryListing = cwd.list();
            for (String element : directoryListing) {
                System.out.println(element);
            }
        }
    }

    /**
     * String Parser - blank String delimiter
     *
     * @param line
     * @return
     */
    public static List<String> parseLine(String line) {
        Scanner inputLine = new Scanner(line);
        List<String> tokens = new ArrayList<String>();

        while (inputLine.hasNext()) {
            String nextToken = inputLine.next();
            tokens.add(nextToken);
        }

        return tokens;
    }
}
