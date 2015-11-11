package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import model.ApplicationSettings;
import view.listener.ChooseStudentsListener;

public class ChooseStudentsFrame extends JFrame {

    private final ChooseStudentsListener chooseStudentslistener;
    private final ApplicationSettings settings;

    public ChooseStudentsFrame(final ChooseStudentsListener chooseStudentslistener, ApplicationSettings settings) {
        this.chooseStudentslistener = chooseStudentslistener;
        this.settings = settings;

        initFrame();

        // Allow new windows to open.
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                chooseStudentslistener.setStudentWindowOpen(false);
            }
        });
    }

    public final void initFrame() {

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        ChooseStudentsPanel panel = new ChooseStudentsPanel(this, settings);
        this.add(panel);

        this.setVisible(true);
        
        //Prevents multiple student selection windows from being opened.
        chooseStudentslistener.setStudentWindowOpen(true);
    }
    
    public ChooseStudentsListener getChooseStudentsListener() {
        return chooseStudentslistener;
    }
}
