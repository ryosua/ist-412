/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import model.ApplicationSettings;

/**
 *
 * @author dos5385
 */
public class OutputFrame extends JFrame {
    
    private final String results;
    private final ApplicationSettings settings;
            
    private OutputPanel output;


    public OutputFrame(String results, ApplicationSettings settings) {
        this.results = results;
        this.settings = settings;
        initFrame();

    }

    public void initFrame() {

        this.setSize(500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        output = new OutputPanel(this, results, settings);
        this.add(output);

        this.setVisible(true);
    }
}
