package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Results;

/**
 * Writes the results to an output file.
 */
public class ResultsController {

    private final File outputFile;
    private final Results results;

    public ResultsController(File outputFile, Results results) {
        this.outputFile = outputFile;
        this.results = results;
    }

    public void writeResults() {
        PrintWriter out = null;
            
        try {
            // Create a new output file if it does not exsit.
            outputFile.createNewFile();
            out = new PrintWriter(outputFile);
            
            for (File file : results.getFiles()) {
                Scanner in = new Scanner(file);
                while (in.hasNext()) {
                    out.println(in.nextLine());
                }
                out.println();
                in.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            out.close();
        }
    }
}
