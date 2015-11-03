package view;

import view.listener.ChooseOutputLocationListener;
import view.listener.ChooseSourceLocationListener;
import view.listener.ChooseTestLocationListener;
import controller.Main;
import java.awt.Component;
import view.listener.ChooseStudentsListener;
import view.listener.ChooseJDKLocationListener;
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
import javax.swing.JTextField;
import model.ApplicationSettings;

public class InputPanel extends JPanel {

    private final Main main;
    private String rootDirectoryFieldText;
    private String jdkDirectoryFieldText;
    private String configFieldText;
    private String sourceDirectoryFieldText;
    private String outputFieldText;
    private String testCaseDirectoryFieldText;

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
        
        final JLabel jdkLabel = new JLabel("Current JDK Selected: ");
        final GridBagConstraints jdkLabelC = new GridBagConstraints();
        jdkLabelC.fill = GridBagConstraints.HORIZONTAL;
        jdkLabelC.gridx = 0;
        jdkLabelC.gridy = 2;

        final JLabel chooseStudentsLabel = new JLabel("Choose Students: ");
        final GridBagConstraints studentsLabelC = new GridBagConstraints();
        studentsLabelC.fill = GridBagConstraints.HORIZONTAL;
        studentsLabelC.gridx = 0;
        studentsLabelC.gridy = 4;
        studentsLabelC.insets = new Insets(5, 0, 0, 0);

        final JLabel sourceDirectoryLabel = new JLabel("Choose a Source Directory or Zip File:");
        final GridBagConstraints sourceLabelC = new GridBagConstraints();
        sourceLabelC.fill = GridBagConstraints.HORIZONTAL;
        sourceLabelC.gridx = 0;
        sourceLabelC.gridy = 6;

        final JLabel testCaseDirectoryLabel = new JLabel("Add Test Case Files:");
        final GridBagConstraints testLabelC = new GridBagConstraints();
        testLabelC.fill = GridBagConstraints.HORIZONTAL;
        testLabelC.gridx = 0;
        testLabelC.gridy = 8;

        final JLabel outputFileLabel = new JLabel("Output file:");
        final GridBagConstraints outputLabelC = new GridBagConstraints();
        outputLabelC.fill = GridBagConstraints.HORIZONTAL;
        outputLabelC.gridx = 0;
        outputLabelC.gridy = 10;

        final ApplicationSettings settings = main.getSettings();

        final JTextField rootDirectoryField = new JTextField();
        rootDirectoryFieldText = settings.getRootDirectory().getPath();
        rootDirectoryField.setText(rootDirectoryFieldText);
        rootDirectoryField.setEditable(false);
        final GridBagConstraints rootDirectoryFieldC = new GridBagConstraints();
        InputPanel.setMinimumSize(rootDirectoryField);
        rootDirectoryFieldC.fill = GridBagConstraints.HORIZONTAL;
        rootDirectoryFieldC.gridx = 0;
        rootDirectoryFieldC.gridy = 1;
        
        final JTextField jdkDirectoryField = new JTextField();
        jdkDirectoryFieldText = settings.getJavaVersionDirectory().getPath();
        jdkDirectoryFieldText = jdkDirectoryFieldText.replace(rootDirectoryFieldText, "~");
        jdkDirectoryField.setText(jdkDirectoryFieldText);
        jdkDirectoryField.setEditable(false);
        final GridBagConstraints jdkFieldC = new GridBagConstraints();
        jdkFieldC.fill = GridBagConstraints.HORIZONTAL;
        jdkFieldC.gridx = 0;
        jdkFieldC.gridy = 3;

        final JTextField studentsField = new JTextField();
        studentsField.setText("No students selected.");
        studentsField.setEditable(false);
        final GridBagConstraints studentsFieldC = new GridBagConstraints();
        studentsFieldC.fill = GridBagConstraints.HORIZONTAL;
        studentsFieldC.gridx = 0;
        studentsFieldC.gridy = 5;
        studentsFieldC.insets = new Insets(0, 0, 30, 0);

        final JTextField sourceDirectoryField = new JTextField();
        sourceDirectoryFieldText = settings.getSourceFileDirectory().getPath();
        sourceDirectoryFieldText = sourceDirectoryFieldText.replace(rootDirectoryFieldText, "~");
        sourceDirectoryField.setText(sourceDirectoryFieldText);
        sourceDirectoryField.setEditable(false);
        final GridBagConstraints sourceFieldC = new GridBagConstraints();
        sourceFieldC.fill = GridBagConstraints.HORIZONTAL;
        sourceFieldC.gridx = 0;
        sourceFieldC.gridy = 7;

        final JTextField outputField = new JTextField();
        outputFieldText = settings.getOutputFileDirectory().getPath();
        outputFieldText = outputFieldText.replace(rootDirectoryFieldText, "~");
        outputField.setText(outputFieldText);
        outputField.setEditable(false);
        final GridBagConstraints outputFieldC = new GridBagConstraints();
        outputFieldC.fill = GridBagConstraints.HORIZONTAL;
        outputFieldC.gridx = 0;
        outputFieldC.gridy = 11;

        final JTextField testCaseDirectoryField = new JTextField();
        testCaseDirectoryFieldText = settings.getTestCaseDirectory().getPath();
        testCaseDirectoryFieldText = testCaseDirectoryFieldText.replace(rootDirectoryFieldText, "~");
        testCaseDirectoryField.setText(testCaseDirectoryFieldText);
        testCaseDirectoryField.setEditable(false);
        final GridBagConstraints testFieldC = new GridBagConstraints();
        testFieldC.fill = GridBagConstraints.HORIZONTAL;
        testFieldC.gridx = 0;
        testFieldC.gridy = 9;
        
        final JButton rootDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints rootDirectoryButtonC = new GridBagConstraints();
        rootDirectoryButtonC.fill = GridBagConstraints.NONE;
        rootDirectoryButtonC.anchor = GridBagConstraints.EAST;
        rootDirectoryButtonC.gridx = 1;
        rootDirectoryButtonC.gridy = 1;
        
        final JButton jdkDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints jdkButtonC = new GridBagConstraints();
        jdkButtonC.fill = GridBagConstraints.NONE;
        jdkButtonC.anchor = GridBagConstraints.EAST;
        jdkButtonC.gridx = 1;
        jdkButtonC.gridy = 3;

        final JButton studentsButton = new JButton("Choose Students");
        final GridBagConstraints configButtonC = new GridBagConstraints();
        configButtonC.fill = GridBagConstraints.NONE;
        configButtonC.anchor = GridBagConstraints.EAST;
        configButtonC.gridx = 1;
        configButtonC.gridy = 5;
        configButtonC.insets = new Insets(0, 0, 30, 0);

        final JButton sourceDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints sourcButtonC = new GridBagConstraints();
        sourcButtonC.fill = GridBagConstraints.NONE;
        sourcButtonC.anchor = GridBagConstraints.EAST;
        sourcButtonC.gridx = 1;
        sourcButtonC.gridy = 7;

        final JButton testCaseButton = new JButton("Choose Location");
        final GridBagConstraints testButtonC = new GridBagConstraints();
        testButtonC.fill = GridBagConstraints.NONE;
        testButtonC.anchor = GridBagConstraints.EAST;
        testButtonC.gridx = 1;
        testButtonC.gridy = 9;

        final JButton outputButton = new JButton("Choose Location");
        final GridBagConstraints outputButtonC = new GridBagConstraints();
        outputButtonC.fill = GridBagConstraints.NONE;
        outputButtonC.anchor = GridBagConstraints.EAST;
        outputButtonC.gridx = 1;
        outputButtonC.gridy = 11;

        final JButton runButton = new JButton("Run");
        runButton.setSize(WIDTH, 10);
        final GridBagConstraints runButtonC = new GridBagConstraints();
        runButtonC.fill = GridBagConstraints.NONE;
        runButtonC.gridx = 1;
        runButtonC.gridy = 12;
        runButtonC.gridwidth = 1;
        runButtonC.anchor = GridBagConstraints.LAST_LINE_END;
        runButtonC.insets = new Insets(25, 0, 0, 0);
        //Run program when clicked.
        runButton.addActionListener(new RunProgramListener(main.getSettings()));

        final JCheckBox showOutputCheckbox = new JCheckBox("Show Output in New Window", true);
        final GridBagConstraints showOutputCheckboxC = new GridBagConstraints();
        showOutputCheckboxC.fill = GridBagConstraints.HORIZONTAL;
        showOutputCheckboxC.gridx = 1;
        showOutputCheckboxC.gridy = 13;
        showOutputCheckboxC.gridwidth = 1;
        showOutputCheckboxC.anchor = GridBagConstraints.LAST_LINE_END;
        showOutputCheckbox.addActionListener(new OutputCheckBoxListener(main.getSettings()));
               
        // Select the show output checkbox if the setting is true.
        showOutputCheckbox.setSelected(settings.getDisplayOutputCheck());
      
        //Action listeners choose file/directory locations and implement runcheck upon selection completion.
        sourceDirectoryButton.addActionListener(new ChooseSourceLocationListener(main, sourceDirectoryField));
        testCaseButton.addActionListener(new ChooseTestLocationListener(main, testCaseDirectoryField));
        outputButton.addActionListener(new ChooseOutputLocationListener(main, outputField));
        rootDirectoryButton.addActionListener(new ChooseRootLocationListener(main, rootDirectoryField));
        jdkDirectoryButton.addActionListener(new ChooseJDKLocationListener(main, jdkDirectoryField));
        studentsButton.addActionListener(new ChooseStudentsListener(settings, studentsField));

        add(rootDirectoryLabel, rootDirectoryLabelC);
        add(rootDirectoryField, rootDirectoryFieldC);
        add(rootDirectoryButton, rootDirectoryButtonC);
        add(jdkDirectoryButton, jdkButtonC);
        add(studentsButton, configButtonC);
        add(jdkLabel, jdkLabelC);
        add(jdkDirectoryField, jdkFieldC);
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
    }
    
    //sets the minimum size for JTextFields
    private static void setMinimumSize(final Component c) {
    c.setMinimumSize(new Dimension(c
        .getPreferredSize().width - 1,
        c.getPreferredSize().height));
    }
    
}
