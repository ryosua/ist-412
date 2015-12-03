package view;

import javax.swing.JFrame;
import model.ApplicationSettings;

public class OutputFrame extends JFrame {

    private final String results;
    private final ApplicationSettings settings;

    private OutputPanel output;

    public OutputFrame(String results, ApplicationSettings settings) {
        this.results = results;
        this.settings = settings;
        initFrame();
    }

    private void initFrame() {
        this.setSize(500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        output = new OutputPanel(this, results, settings);
        this.add(output);

        this.setVisible(true);
    }
}
