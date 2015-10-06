/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author dos5385
 */
public class OutputFrame extends JFrame{
    private  OutputPanel output;
    private String results;
    public OutputFrame(String results){
        this.results = results;
        initFrame();
        
    }
    
    public void initFrame(){
        
        this.setSize(500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        output = new OutputPanel(this, results);
        this.add(output);
        
        
        this.setVisible(true);
    }
}
