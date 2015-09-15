package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Results;

public class ResultsController {

    private final File outputFile;
    private final Results results;

    public ResultsController(File outputFile, Results results) {
        this.outputFile = outputFile;
        this.results = results;
    }

    public void writeResults() {
        try (PrintWriter out = new PrintWriter(outputFile)) {
            for (File file : results.getFiles()) {
                Scanner in = new Scanner(file);
                while (in.hasNext()) {
                    out.println(in.nextLine());
                }
                in.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
