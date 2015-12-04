package view;

import view.listener.ChooseOutputLocationListener;
import view.listener.ChooseSourceLocationListener;
import view.listener.ChooseTestLocationListener;
import controller.Main;
import java.awt.Component;
import view.listener.ChooseStudentsListener;
import view.listener.ChooseRootLocationListener;
import view.listener.OutputCheckBoxListener;
import view.listener.RunProgramListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class InputPanel extends JPanel {

    private final Main main;
    private String rootDirectoryFieldText;
    private String sourceDirectoryFieldText;
    private String outputFieldText;
    private JProgressBar progressBar;
    private String testCaseDirectoryFieldText;

    private JButton rootDirectoryButton;
    private JButton studentsButton;
    private JButton sourceDirectoryButton;
    private JButton testCaseButton;
    private JButton outputButton;

    public InputPanel(Main main) {
        this.main = main;

        createAndAddComponents();
    }

    private void createAndAddComponents() {
        final GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        final JLabel rootDirectoryLabel = new JLabel("Root Directory:");
        final GridBagConstraints rootDirectoryLabelC = new GridBagConstraints();
        rootDirectoryLabelC.fill = GridBagConstraints.HORIZONTAL;
        rootDirectoryLabelC.gridx = 0;
        rootDirectoryLabelC.gridy = 0;

        final JLabel chooseStudentsLabel = new JLabel("Choose Students: ");
        final GridBagConstraints studentsLabelC = new GridBagConstraints();
        studentsLabelC.fill = GridBagConstraints.HORIZONTAL;
        studentsLabelC.gridx = 0;
        studentsLabelC.gridy = 10;
        studentsLabelC.insets = new Insets(5, 0, 0, 0);

        final JLabel sourceDirectoryLabel = new JLabel("Choose Unzipped Source Directory Student Files:");
        final GridBagConstraints sourceLabelC = new GridBagConstraints();
        sourceLabelC.fill = GridBagConstraints.HORIZONTAL;
        sourceLabelC.gridx = 0;
        sourceLabelC.gridy = 6;

        final JLabel testCaseDirectoryLabel = new JLabel("Choose Config File Folder:");
        final GridBagConstraints testLabelC = new GridBagConstraints();
        testLabelC.fill = GridBagConstraints.HORIZONTAL;
        testLabelC.gridx = 0;
        testLabelC.gridy = 8;

        final JLabel outputFileLabel = new JLabel("Output file:");
        final GridBagConstraints outputLabelC = new GridBagConstraints();
        outputLabelC.fill = GridBagConstraints.HORIZONTAL;
        outputLabelC.gridx = 0;
        outputLabelC.gridy = 4;

        final ApplicationSettings settings = main.getSettings();

        final JTextField rootDirectoryField = new JTextField();
        rootDirectoryFieldText = settings.getRootDirectory().getAbsolutePath();
        rootDirectoryField.setText(rootDirectoryFieldText);
        rootDirectoryField.setEditable(false);
        final GridBagConstraints rootDirectoryFieldC = new GridBagConstraints();
        InputPanel.setMinimumSize(rootDirectoryField);
        rootDirectoryFieldC.fill = GridBagConstraints.HORIZONTAL;
        rootDirectoryFieldC.gridx = 0;
        rootDirectoryFieldC.gridy = 1;

        final JTextField studentsField = new JTextField();
        studentsField.setText("No students selected.");
        studentsField.setEditable(false);
        final GridBagConstraints studentsFieldC = new GridBagConstraints();
        studentsFieldC.fill = GridBagConstraints.HORIZONTAL;
        studentsFieldC.gridx = 0;
        studentsFieldC.gridy = 11;
        //studentsFieldC.insets = new Insets(0, 0, 30, 0);

        final JTextField sourceDirectoryField = new JTextField();
        sourceDirectoryFieldText = settings.getSourceFileDirectory().getAbsolutePath();
        sourceDirectoryFieldText = sourceDirectoryFieldText.replace(rootDirectoryFieldText, "~");
        sourceDirectoryField.setText(sourceDirectoryFieldText);
        sourceDirectoryField.setEditable(false);
        final GridBagConstraints sourceFieldC = new GridBagConstraints();
        sourceFieldC.fill = GridBagConstraints.HORIZONTAL;
        sourceFieldC.gridx = 0;
        sourceFieldC.gridy = 7;

        final JTextField outputField = new JTextField();
        outputFieldText = settings.getOutputFileDirectory().getAbsolutePath();
        outputFieldText = outputFieldText.replace(rootDirectoryFieldText, "~");
        outputField.setText(outputFieldText);
        outputField.setEditable(false);
        final GridBagConstraints outputFieldC = new GridBagConstraints();
        outputFieldC.fill = GridBagConstraints.HORIZONTAL;
        outputFieldC.gridx = 0;
        outputFieldC.gridy = 5;

        final JTextField testCaseDirectoryField = new JTextField();
        testCaseDirectoryFieldText = settings.getTestCaseDirectory().getAbsolutePath();
        testCaseDirectoryFieldText = testCaseDirectoryFieldText.replace(rootDirectoryFieldText, "~");
        testCaseDirectoryField.setText(testCaseDirectoryFieldText);
        testCaseDirectoryField.setEditable(false);
        final GridBagConstraints testFieldC = new GridBagConstraints();
        testFieldC.fill = GridBagConstraints.HORIZONTAL;
        testFieldC.gridx = 0;
        testFieldC.gridy = 9;
        testFieldC.insets = new Insets(0, 0, 30, 0);

        rootDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints rootDirectoryButtonC = new GridBagConstraints();
        rootDirectoryButtonC.fill = GridBagConstraints.NONE;
        rootDirectoryButtonC.anchor = GridBagConstraints.EAST;
        rootDirectoryButtonC.gridx = 1;
        rootDirectoryButtonC.gridy = 1;

        studentsButton = new JButton("Choose Students");
        final GridBagConstraints configButtonC = new GridBagConstraints();
        configButtonC.fill = GridBagConstraints.NONE;
        configButtonC.anchor = GridBagConstraints.EAST;
        configButtonC.gridx = 1;
        configButtonC.gridy = 11;
        //configButtonC.insets = 

        sourceDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints sourcButtonC = new GridBagConstraints();
        sourcButtonC.fill = GridBagConstraints.NONE;
        sourcButtonC.anchor = GridBagConstraints.EAST;
        sourcButtonC.gridx = 1;
        sourcButtonC.gridy = 7;

        testCaseButton = new JButton("Choose Location");
        final GridBagConstraints testButtonC = new GridBagConstraints();
        testButtonC.fill = GridBagConstraints.NONE;
        testButtonC.anchor = GridBagConstraints.EAST;
        testButtonC.gridx = 1;
        testButtonC.gridy = 9;
        testButtonC.insets = new Insets(0, 0, 30, 0);

        outputButton = new JButton("Choose Location");
        final GridBagConstraints outputButtonC = new GridBagConstraints();
        outputButtonC.fill = GridBagConstraints.NONE;
        outputButtonC.anchor = GridBagConstraints.EAST;
        outputButtonC.gridx = 1;
        outputButtonC.gridy = 5;

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setValue(0);

        final JButton runButton = new JButton("Run");
        runButton.setSize(WIDTH, 10);
        final GridBagConstraints runButtonC = new GridBagConstraints();
        runButtonC.fill = GridBagConstraints.NONE;
        runButtonC.gridx = 1;
        runButtonC.gridy = 13;
        runButtonC.gridwidth = 1;
        runButtonC.anchor = GridBagConstraints.LAST_LINE_END;
        //Run program when clicked.
        runButton.addActionListener(new RunProgramListener(main.getSettings(), this));

        final JCheckBox showOutputCheckbox = new JCheckBox("Show Output in New Window", true);
        final GridBagConstraints showOutputCheckboxC = new GridBagConstraints();
        showOutputCheckboxC.fill = GridBagConstraints.HORIZONTAL;
        showOutputCheckboxC.gridx = 0;
        showOutputCheckboxC.gridy = 12;
        showOutputCheckboxC.gridwidth = 1;
        showOutputCheckboxC.anchor = GridBagConstraints.LAST_LINE_END;
        showOutputCheckbox.addActionListener(new OutputCheckBoxListener(main.getSettings()));

        final GridBagConstraints progressBarC = new GridBagConstraints();
        progressBarC.fill = GridBagConstraints.HORIZONTAL;
        progressBarC.gridx = 0;
        progressBarC.gridy = 13;
        progressBarC.gridwidth = 1;
        progressBarC.anchor = GridBagConstraints.LAST_LINE_END;

        // Select the show output checkbox if the setting is true.
        showOutputCheckbox.setSelected(settings.getDisplayOutputCheck());

        //Action listeners choose file/directory locations and implement runcheck upon selection completion.
        sourceDirectoryButton.addActionListener(new ChooseSourceLocationListener(main, sourceDirectoryField));
        testCaseButton.addActionListener(new ChooseTestLocationListener(main, testCaseDirectoryField));
        outputButton.addActionListener(new ChooseOutputLocationListener(main, outputField));
        rootDirectoryButton.addActionListener(new ChooseRootLocationListener(main, rootDirectoryField));
        studentsButton.addActionListener(new ChooseStudentsListener(settings, studentsField));

        add(rootDirectoryLabel, rootDirectoryLabelC);
        add(rootDirectoryField, rootDirectoryFieldC);
        add(rootDirectoryButton, rootDirectoryButtonC);
        add(studentsButton, configButtonC);
        add(chooseStudentsLabel, studentsLabelC);
        add(studentsField, studentsFieldC);
        add(sourceDirectoryLabel, sourceLabelC);
        add(sourceDirectoryField, sourceFieldC);
        add(sourceDirectoryButton, sourcButtonC);
        add(testCaseDirectoryLabel, testLabelC);
        add(testCaseDirectoryField, testFieldC);
        add(testCaseButton, testButtonC);
        add(outputFileLabel, outputLabelC);
        add(outputField, outputFieldC);
        add(outputButton, outputButtonC);
        add(runButton, runButtonC);
        add(showOutputCheckbox, showOutputCheckboxC);
        add(progressBar, progressBarC);
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setButtonsEnabled(boolean enabled) {
        rootDirectoryButton.setEnabled(enabled);
        studentsButton.setEnabled(enabled);
        sourceDirectoryButton.setEnabled(enabled);
        testCaseButton.setEnabled(enabled);
        outputButton.setEnabled(enabled);
    }

    //sets the minimum size for JTextFields
    private static void setMinimumSize(final Component c) {
        c.setMinimumSize(new Dimension(c
                .getPreferredSize().width - 1,
                c.getPreferredSize().height));
    }

}
