package view;

import javax.swing.JOptionPane;

public class FileNotFoundWarning {

    public static void showWarning() {
        JOptionPane.showMessageDialog(null, "Please check that the files you have selected are correct.", "File not found", JOptionPane.WARNING_MESSAGE);
    }
}
