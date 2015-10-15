package controller;

import java.io.File;
import javax.swing.JFileChooser;

public class FileController {
    
    public static final File emptyFile = new File("");
    
    private final JFileChooser fileChooser;
    private final Main main;
  
    public FileController(Main main) {
        this.fileChooser = new JFileChooser(main.getSettings().getRootDirectory());
        this.main = main;

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
        if (dialogType == JFileChooser.SAVE_DIALOG) {
            fileChooser.setDialogTitle("Choose a location");
            fileChooser.setApproveButtonText("Choose");
        }

        int returnVal = fileChooser.showOpenDialog(main.getFrame());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        } else {
            file = emptyFile;
        }

        return file;
    }
    
    /**
     * Sets the JFileChooser to allow the user to just select files, just select directories, or select both files and directories. The default is JFilesChooser.FILES_ONLY.
     * @param mode the type of files to be displayed:
     *     JFileChooser.FILES_ONLY
     *     JFileChooser.DIRECTORIES_ONLY
     *     JFileChooser.FILES_AND_DIRECTORIES
     */
    public void setFileSelectionMode(int mode) {
        fileChooser.setFileSelectionMode(mode);
    }
    
    /**
     * Sets the type of this dialog.
     * @param mode the type of dialog to be displayed:
     *     JFileChooser.OPEN_DIALOG
     *     JFileChooser.SAVE_DIALOG
     *     JFileChooser.CUSTOM_DIALOG
     */
    public void setDialogType(int mode) {
        fileChooser.setDialogType(mode);
    }
}
