package view;

import model.ApplicationSettings;
import controller.FileController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

    private final ApplicationSettings settings = new ApplicationSettings();
    private final JFrame frame;
    private final FileController theFileController;

    public InputPanel(JFrame frame, FileController theFileController) {
        this.frame = frame;
        this.theFileController = theFileController;
        
        final GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        final JLabel sourceDirectoryLabel = new JLabel("Choose a Source Directory or Zip File:");
        final GridBagConstraints sourceLabelC = new GridBagConstraints();
        sourceLabelC.fill = GridBagConstraints.HORIZONTAL;
        sourceLabelC.gridx = 0;
        sourceLabelC.gridy = 0;
        
        final JLabel testCaseDirectoryLabel = new JLabel("Add Test Case Files:");
        final GridBagConstraints testLabelC = new GridBagConstraints();
        testLabelC.fill = GridBagConstraints.HORIZONTAL;
        testLabelC.gridx = 0;
        testLabelC.gridy = 2;
        
        final JTextField sourceDirectoryField = new JTextField();
        sourceDirectoryField.setEditable(false);
        final GridBagConstraints sourceFieldC = new GridBagConstraints();
        sourceFieldC.fill = GridBagConstraints.HORIZONTAL;
        sourceFieldC.gridx = 0;
        sourceFieldC.gridy = 1;
        
        final JTextField testCaseDirectoryField = new JTextField();
        testCaseDirectoryField.setEditable(false);
        final GridBagConstraints testFieldC = new GridBagConstraints();
        testFieldC.fill = GridBagConstraints.HORIZONTAL;
        testFieldC.gridx = 0;
        testFieldC.gridy = 3;

        final JButton sourceDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints sourcButtonC = new GridBagConstraints();
        sourcButtonC.fill = GridBagConstraints.HORIZONTAL;
        sourcButtonC.gridx = 1;
        sourcButtonC.gridy = 1;
        sourceDirectoryButton.addActionListener(new ChooseSourceLocationListener(theFileController, settings, sourceDirectoryField));
        
        final JButton testCaseButton = new JButton("Choose Location");
        final GridBagConstraints testButtonC = new GridBagConstraints();
        testButtonC.fill = GridBagConstraints.HORIZONTAL;
        testButtonC.gridx = 1;
        testButtonC.gridy = 3;
        testCaseButton.addActionListener(new ChooseSourceLocationListener(theFileController, settings, testCaseDirectoryField));
      
        add(sourceDirectoryLabel, sourceLabelC);
        add(sourceDirectoryField, sourceFieldC);
        add(sourceDirectoryButton, sourcButtonC);
        add(testCaseDirectoryLabel, testLabelC);
        add(testCaseDirectoryField, testFieldC);
        add(testCaseButton, testButtonC);
    }

    private class ChooseSourceLocationListener implements ActionListener {

        private final FileController fileController;
        private final ApplicationSettings settings;
        private final JTextField textField;

        public ChooseSourceLocationListener(FileController fileController, ApplicationSettings settings, JTextField textField) {
            this.fileController = fileController;
            this.settings = settings;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            settings.setSourceFileDirectory(fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG));
            textField.setText(settings.getSourceFileDirectory().getPath());
        }
    }
    
    private class ChooseTestLocationListener implements ActionListener {

        private final FileController fileController;
        private final ApplicationSettings settings;
        private final JTextField textField;

        public ChooseTestLocationListener(FileController fileController, ApplicationSettings settings, JTextField textField) {
            this.fileController = fileController;
            this.settings = settings;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            settings.setTestCaseDirectory(fileController.getFileFromChooser(JFileChooser.SAVE_DIALOG));
            textField.setText(settings.getTestCaseDirectory().getPath());
        }
    }
}
