package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileController {
    
    public static final File emptyFile = new File("");

    private final JFileChooser fileChooser;
    private final JFrame frame;

    public FileController(JFrame frame) {
        this.fileChooser = new JFileChooser();
        this.frame = frame;

        fileChooser.setDialogType(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    }

    /**
     * Opens the file chooser, and returns the File selected.
     *
     * @param dialogType JFileChooser.OPEN_DIALOG or JFileChooser.SAVE_DIALOG
     * @return the file if chosen or the empty file if canceled
     */
    public File getFileFromChooser(int dialogType) {
        File file = null;

        fileChooser.setDialogType(dialogType);

        if (dialogType == JFileChooser.SAVE_DIALOG) {
            fileChooser.setDialogTitle("Choose a location");
            fileChooser.setApproveButtonText("Choose");
        }

        int returnVal = fileChooser.showOpenDialog(frame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        } else {
            file = emptyFile;
        }

        return file;
    }
}
