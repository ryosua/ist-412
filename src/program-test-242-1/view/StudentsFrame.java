package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import model.ApplicationSettings;
import view.listener.ChooseStudentsListener;

public class StudentsFrame extends JFrame {

    private final ChooseStudentsListener chooseStudentslistener;
    private final ApplicationSettings settings;

    public StudentsFrame(final ChooseStudentsListener chooseStudentslistener, ApplicationSettings settings) {
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

        StudentsPanel panel = new StudentsPanel(this, settings);
        this.add(panel);

        this.setVisible(true);
        chooseStudentslistener.setStudentWindowOpen(true);
    }
}
