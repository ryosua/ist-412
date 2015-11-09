package view;

import controller.Main;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class HelpFrame extends JFrame {

    private final Main main;

    private HelpTextPanel textPanel;
    private HelpImagePanel imagePanel;
    private HelpButtonPanel buttonPanel;

    public HelpFrame(Main main) {
        this.main = main;
        initFrame();
    }

    private void initFrame() {
        setSize(800, 600);
        setTitle("Help");
        setLayout(new BorderLayout());

        textPanel = new HelpTextPanel(main);
        imagePanel = new HelpImagePanel(main);
        buttonPanel = new HelpButtonPanel(textPanel, imagePanel);

        add(textPanel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public HelpTextPanel getTextPanel() {
        return textPanel;
    }

    public HelpImagePanel getImagePanel() {
        return imagePanel;
    }

    public HelpButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
