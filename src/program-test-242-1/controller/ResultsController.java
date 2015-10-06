package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.ApplicationSettings;
import model.Results;
import view.OutputFrame;

/**
 * Writes the results to an output file.
 */
public class ResultsController {

    private ApplicationSettings settings;
    private final File outputFile;
    private final Results results;
    private String resultDatatoPrint = "";
    private OutputFrame frame;
    
    public ResultsController(ApplicationSettings settings, Results results) {
        this.settings = settings;
        this.outputFile = this.settings.getOutputFileDirectory();
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
                    String line = in.nextLine();
                    out.println(line);
                    resultDatatoPrint +=line + "\n";
                }
                out.println();
                in.close();
                //System.out.println("\n\n\n\n\n\nRESULTS\n\n\n\n\n\n" + resultDatatoPrint);
            }
            
            
            if(settings.getDisplayOutputCheck().equals(Boolean.TRUE.toString()))
                frame = new OutputFrame(resultDatatoPrint);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            out.close();
        }
    }
}
