package view;

import controller.OutputController;
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

    public void initFrame() {
        this.setSize(500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        OutputController outputController = new OutputController();
        output = new OutputPanel(this, results, settings , outputController);
        this.add(output);

        this.setVisible(true);
    }
}
