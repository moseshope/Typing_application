/*
   Khanh Do
   CIS 2151 – Prof. John P. Baugh
   Summer 2016
   Programming Assignment 3
*/

import javax.swing.*;
import java.awt.*;

/**
   The LabelsPanel class creates a panel containing the instructions for the 
   user.
   @author Khanh Do
   @version July 27, 2016
*/

public class LabelsPanel extends JPanel
{
    private final int PANEL_WIDTH = 400;              
    private final int PANEL_HEIGHT = 200;             
    private JLabel instruction1;            //first instruction for the user
    private JLabel instruction2;            //second instruction for the user
    private JLabel blankLine;               //a blank line used for spacing
        
    /**
       The constructor builds a panel which contains the instruction labels.
    */
    
    public LabelsPanel()
    {
        setSize(PANEL_WIDTH, PANEL_HEIGHT);           
        setLayout( new GridLayout(3, 1) );
        
        instruction1 = new JLabel("Type some text using your keyboard. " + 
                "The keys you press will be highlighted and the text will " +
                "be displayed.");
        instruction2 = new JLabel("Note: Clicking the buttons with your" + 
                " mouse will not perform any action.");
        blankLine = new JLabel("");
        add(instruction1);
        add(instruction2);
        add(blankLine);
    }
}
