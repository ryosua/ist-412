package controller.listener;

import controller.BatchTester;
import controller.ProgramTester;
import controller.SingleTester;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunProgramListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ProgramTester tester;
                
        // This needs to be changed to if single mode.
        if (true) {
            tester = new SingleTester();
          
        // This needs to be changed to if batch mode.
        } else if (false) {
            tester = new BatchTester();
        }
        tester.run();
    }

}
