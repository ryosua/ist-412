package view.listener;

import controller.BatchTester;
import controller.ProgramTester;
import controller.SingleTester;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationSettings;

public class RunProgramListener implements ActionListener {
    
    private final ApplicationSettings settings;
    
    public RunProgramListener(ApplicationSettings settings) {
        this.settings = settings;
        
        System.out.println(settings.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProgramTester tester;
                
        // This needs to be changed to if single mode.
        if (settings.getRunMode().equals(ApplicationSettings.SINGLE_MODE)) {
            System.out.println("Running in single mode");
            tester = new SingleTester(settings);
        // This needs to be changed to if batch mode.
        } else {
            System.out.println("Running in batch mode");
            tester = new BatchTester(settings);
        }
        tester.run();
    }

}
