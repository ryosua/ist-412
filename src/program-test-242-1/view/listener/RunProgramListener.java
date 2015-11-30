package view.listener;

import controller.BatchTester;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationSettings;
import view.InputPanel;

public class RunProgramListener implements ActionListener {
    
    private final InputPanel inputPanel;
    private final ApplicationSettings settings;
    
    public RunProgramListener(ApplicationSettings settings, InputPanel inputPanel) {
        this.settings = settings;
        this.inputPanel = inputPanel;
        
        System.out.println(settings.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Running in batch mode");
        final BatchTester tester = new BatchTester(settings, inputPanel);
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                tester.run();
            }
        };
        
        Thread batchTesterThread = new Thread(r);
        batchTesterThread.start();
    }

}
