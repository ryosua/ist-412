/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import view.TrivialEdit;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationSettings;
import model.Student;
import view.OutputPanel;

/**
 *
 * @author qyl5054
 */
public class OpenOutputWindowListener implements ActionListener {

    private final OutputPanel thePanel;
    private final ApplicationSettings settings;
    
    private Student student;

    public OpenOutputWindowListener(OutputPanel panel, ApplicationSettings settings, Student student) {
        this.thePanel = panel;
        this.settings = settings;
        this.student = student;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TrivialEdit editor = new TrivialEdit();
        editor.doOpenOnStart(student.getOutputFileName());
        editor.setVisible(true);
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
}
