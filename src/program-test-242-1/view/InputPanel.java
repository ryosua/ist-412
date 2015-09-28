package view;

import controller.listener.ChooseOutputLocationListener;
import controller.listener.ChooseSourceLocationListener;
import controller.listener.ChooseTestLocationListener;
import controller.Main;
import controller.listener.ChooseConfigLocationListener;
import controller.listener.ChooseJDKLocationListener;
import controller.listener.RadioButtonListener;
import controller.listener.RunProgramListener;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.ApplicationSettings;

public class InputPanel extends JPanel {

    private final Main main;
    private final JTextField configField, jdkDirectoryField;

    public InputPanel(Main main) {
        this.main = main;
        configField = new JTextField();
        jdkDirectoryField = new JTextField();

        createAndAddComponents();
    }

    private void createAndAddComponents() {
        final GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        
        final JLabel jdkLabel = new JLabel("Current JDK Selected: ");
        final GridBagConstraints jdkLabelC = new GridBagConstraints();
        jdkLabelC.fill = GridBagConstraints.HORIZONTAL;
        jdkLabelC.gridx = 0;
        jdkLabelC.gridy = 0;
        
        final JLabel configLabel = new JLabel("Current Config Selected: ");
        final GridBagConstraints configLabelC = new GridBagConstraints();
        configLabelC.fill = GridBagConstraints.HORIZONTAL;
        configLabelC.gridx = 0;
        configLabelC.gridy = 2;
        configLabelC.insets = new Insets(5,0,0,0);

        final JLabel sourceDirectoryLabel = new JLabel("Choose a Source Directory or Zip File:");
        final GridBagConstraints sourceLabelC = new GridBagConstraints();
        sourceLabelC.fill = GridBagConstraints.HORIZONTAL;
        sourceLabelC.gridx = 0;
        sourceLabelC.gridy = 4;

        final JLabel testCaseDirectoryLabel = new JLabel("Add Test Case Files:");
        final GridBagConstraints testLabelC = new GridBagConstraints();
        testLabelC.fill = GridBagConstraints.HORIZONTAL;
        testLabelC.gridx = 0;
        testLabelC.gridy = 6;
        
        final JLabel outputFileLabel = new JLabel("Output file:");
        final GridBagConstraints outputLabelC = new GridBagConstraints();
        outputLabelC.fill = GridBagConstraints.HORIZONTAL;
        outputLabelC.gridx = 0;
        outputLabelC.gridy = 8;
        
        final ApplicationSettings settings = main.getSettings();

        //final JTextField jdkDirectoryField = new JTextField();
        jdkDirectoryField.setText(settings.getJavaVersionDirectory().getPath());
        jdkDirectoryField.setEditable(false);
        final GridBagConstraints jdkFieldC = new GridBagConstraints();
        jdkFieldC.fill = GridBagConstraints.HORIZONTAL;
        jdkFieldC.gridx = 0;
        jdkFieldC.gridy = 1;
        
        //final JTextField configField = new JTextField();
        configField.setText(settings.getConfigFile().getPath());
        configField.setEditable(false);
        final GridBagConstraints configFieldC = new GridBagConstraints();
        configFieldC.fill = GridBagConstraints.HORIZONTAL;
        configFieldC.gridx = 0;
        configFieldC.gridy = 3;
        configFieldC.insets = new Insets(0,0,30,0);
        
        final JTextField sourceDirectoryField = new JTextField();
        sourceDirectoryField.setText(settings.getSourceFileDirectory().getPath());
        sourceDirectoryField.setEditable(false);
        final GridBagConstraints sourceFieldC = new GridBagConstraints();
        sourceFieldC.fill = GridBagConstraints.HORIZONTAL;
        sourceFieldC.gridx = 0;
        sourceFieldC.gridy = 5;
        
        final JTextField outputField = new JTextField();
        outputField.setText(settings.getOutputFileDirectory().getPath());
        outputField.setEditable(false);
        final GridBagConstraints outputFieldC = new GridBagConstraints();
        outputFieldC.fill = GridBagConstraints.HORIZONTAL;
        outputFieldC.gridx = 0;
        outputFieldC.gridy = 9;

        final JTextField testCaseDirectoryField = new JTextField();
        testCaseDirectoryField.setText(settings.getTestCaseDirectory().getPath());
        testCaseDirectoryField.setEditable(false);
        final GridBagConstraints testFieldC = new GridBagConstraints();
        testFieldC.fill = GridBagConstraints.HORIZONTAL;
        testFieldC.gridx = 0;
        testFieldC.gridy = 7;

        final JButton sourceDirectoryButton = new JButton("Choose Location");
        final GridBagConstraints sourcButtonC = new GridBagConstraints();
        sourcButtonC.fill = GridBagConstraints.HORIZONTAL;
        sourcButtonC.gridx = 1;
        sourcButtonC.gridy = 5;

        final JButton testCaseButton = new JButton("Choose Location");
        final GridBagConstraints testButtonC = new GridBagConstraints();
        testButtonC.fill = GridBagConstraints.HORIZONTAL;
        testButtonC.gridx = 1;
        testButtonC.gridy = 7;
        
        final JButton outputButton = new JButton("Choose Location");
        final GridBagConstraints outputButtonC = new GridBagConstraints();
        outputButtonC.fill = GridBagConstraints.HORIZONTAL;
        outputButtonC.gridx = 1;
        outputButtonC.gridy = 9;

        final JButton runButton = new JButton("Run");
        final GridBagConstraints runButtonC = new GridBagConstraints();
        runButtonC.fill = GridBagConstraints.HORIZONTAL;
        runButtonC.gridx = 1;
        runButtonC.gridy = 10;
        runButtonC.gridwidth = 1;
        runButtonC.anchor = GridBagConstraints.LAST_LINE_END;
        runButtonC.insets = new Insets(25,0,0,0);
        //Run program when clicked.
        runButton.addActionListener(new RunProgramListener(main.getSettings()));
        
        final JRadioButton singleRun = new JRadioButton("Single Run");
        final GridBagConstraints singleRunBtn = new GridBagConstraints();
        singleRunBtn.fill = GridBagConstraints.HORIZONTAL;
        singleRunBtn.gridx = 0;
        singleRunBtn.gridy = 10;
        singleRun.setSelected(true);
        
        final JRadioButton batchRun = new JRadioButton("Batch Run");
        final GridBagConstraints batchRunBtn = new GridBagConstraints();
        batchRunBtn.fill = GridBagConstraints.HORIZONTAL;
        batchRunBtn.gridx = 0;
        batchRunBtn.gridy = 11;
        
        //Add runtype radio buttons to button group.
        final ButtonGroup runTypeRadios = new ButtonGroup();
        runTypeRadios.add(singleRun);
        runTypeRadios.add(batchRun);
        
        //Action listeners choose file/directory locations and implement runcheck upon selection completion.
        sourceDirectoryButton.addActionListener(new ChooseSourceLocationListener(main, sourceDirectoryField));
        testCaseButton.addActionListener(new ChooseTestLocationListener(main, testCaseDirectoryField));
        outputButton.addActionListener(new ChooseOutputLocationListener(main, outputField));
        singleRun.addActionListener(new RadioButtonListener(singleRun, batchRun));
        batchRun.addActionListener(new RadioButtonListener(singleRun, batchRun));
        
        add(jdkLabel, jdkLabelC);
        add(jdkDirectoryField, jdkFieldC);
        add(configLabel, configLabelC);
        add(configField, configFieldC);
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
    
    public JTextField getConfigField(){
        return configField;
    }
    
    public JTextField getJDKField(){
        return jdkDirectoryField;
    }
}
