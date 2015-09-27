package view;

import controller.listener.ChooseOutputLocationListener;
import controller.listener.ChooseSourceLocationListener;
import controller.listener.ChooseTestLocationListener;
import controller.Main;
import controller.listener.RunProgramListener;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class InputPanel extends JPanel {

    private final Main main;

    public InputPanel(Main main) {
        this.main = main;

        createAndAddComponents();
    }

    private void createAndAddComponents() {
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
        
        final JLabel outputFileLabel = new JLabel("Output file:");
        final GridBagConstraints outputLabelC = new GridBagConstraints();
        outputLabelC.fill = GridBagConstraints.HORIZONTAL;
        outputLabelC.gridx = 0;
        outputLabelC.gridy = 4;
        
        final ApplicationSettings settings = main.getSettings();

        final JTextField sourceDirectoryField = new JTextField();
        sourceDirectoryField.setText(settings.getSourceFileDirectory().getPath());
        sourceDirectoryField.setEditable(false);
        final GridBagConstraints sourceFieldC = new GridBagConstraints();
        sourceFieldC.fill = GridBagConstraints.HORIZONTAL;
        sourceFieldC.gridx = 0;
        sourceFieldC.gridy = 1;
        
        final JTextField outputField = new JTextField();
        outputField.setText(settings.getOutputFileDirectory().getPath());
        outputField.setEditable(false);
        final GridBagConstraints outputFieldC = new GridBagConstraints();
        outputFieldC.fill = GridBagConstraints.HORIZONTAL;
        outputFieldC.gridx = 0;
        outputFieldC.gridy = 5;

        final JTextField testCaseDirectoryField = new JTextField();
        testCaseDirectoryField.setText(settings.getTestCaseDirectory().getPath());
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

        final JButton testCaseButton = new JButton("Choose Location");
        final GridBagConstraints testButtonC = new GridBagConstraints();
        testButtonC.fill = GridBagConstraints.HORIZONTAL;
        testButtonC.gridx = 1;
        testButtonC.gridy = 3;
        
        final JButton outputButton = new JButton("Choose Location");
        final GridBagConstraints outputButtonC = new GridBagConstraints();
        outputButtonC.fill = GridBagConstraints.HORIZONTAL;
        outputButtonC.gridx = 1;
        outputButtonC.gridy = 5;

        final JButton runButton = new JButton("Run");
        final GridBagConstraints runButtonC = new GridBagConstraints();
        runButtonC.fill = GridBagConstraints.HORIZONTAL;
        runButtonC.gridx = 1;
        runButtonC.gridy = 6;
        runButtonC.gridwidth = 1;
        runButtonC.anchor = GridBagConstraints.LAST_LINE_END;
        runButtonC.insets = new Insets(25,0,0,0);
        //Run program when clicked.
        runButton.addActionListener(new RunProgramListener(main.getSettings()));
        
        final JRadioButton singleRun = new JRadioButton("Single Run");
        final GridBagConstraints singleRunBtn = new GridBagConstraints();
        singleRunBtn.fill = GridBagConstraints.HORIZONTAL;
        singleRunBtn.gridx = 0;
        singleRunBtn.gridy = 6;
        //singleRunBtn.addActionListener(new );
        singleRun.setSelected(true);
        
        final JRadioButton batchRun = new JRadioButton("Batch Run");
        final GridBagConstraints batchRunBtn = new GridBagConstraints();
        batchRunBtn.fill = GridBagConstraints.HORIZONTAL;
        batchRunBtn.gridx = 0;
        batchRunBtn.gridy = 7;
        //batchRunBtn.addActionListener(new );
        
        //Action listeners choose file/directory locations and implement runcheck upon selection completion.
        sourceDirectoryButton.addActionListener(new ChooseSourceLocationListener(main, sourceDirectoryField));
        testCaseButton.addActionListener(new ChooseTestLocationListener(main, testCaseDirectoryField));
        outputButton.addActionListener(new ChooseOutputLocationListener(main, outputField));

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
        add(singleRun, singleRunBtn);
        add(batchRun, batchRunBtn);
        
    }
}
