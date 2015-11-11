/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dan
 */
public class StudentTableModel extends AbstractTableModel {

    ArrayList<Student> studentArrayList;
    String[] columnHeaders = {"Students"};
    public StudentTableModel(ArrayList<Student> students){
        studentArrayList = students;
    }
    
    
    
    @Override
    public int getRowCount() {
        return studentArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return studentArrayList.get(rowIndex).getStudentName();
    }
    
    @Override
    public String getColumnName(int column){
        return columnHeaders[column];
    }
    
}
