/*
   Khanh Do
   CIS 2151 – Prof. John P. Baugh
   Summer 2016
   Programming Assignment 3
*/

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;

/**
   The KeyboardPanel class creates a set of buttons to visually represent the
   keys on a physical keyboard.
   @author Khanh Do
   @version July 27, 2016
*/

public class KeyboardPanel extends JPanel 
{
    private final int INITIAL_VALUE = 0;
    private final int HORIZONTAL_GAP = 2;
    private final int VERTICAL_GAP = 2;
    private final int HEIGHT1 = 50;      //use for height of buttons
    private final int WIDTH1 = 25;      //use WIDTH constants for button widths
    private final int WIDTH2 = 50;
    private final int WIDTH3 = 65;
    private final int WIDTH4 = 75;
    private final int WIDTH5 = 100;
    private final int WIDTH6 = 200;
    private final int WIDTH7 = 325;
    
    private int previousKey;            //holds the key code of the previous key
    private JLabel smallSpacer;         //A JLabel used as a small spacer
    private JLabel mediumSpacer;        //A JLabel used as a medium spacer
    private JLabel largeSpacer;         //A JLabel used as a large spacer
    private String[] buttonNames;       //text for buttons 
    private JButton button;             //the button being created
    ArrayList<JButton> buttons = new ArrayList<>(); //array of button objects
    private JPanel row;                 //the row being created to hold buttons
    ArrayList<JPanel> rows = new ArrayList<>();     //array of row panels
    
    /**
       The constructor creates a panel containing buttons which represent keys
       on a keyboard.
    */
    
    public KeyboardPanel()
    {
        previousKey = INITIAL_VALUE;
        setLayout( new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP,
                   VERTICAL_GAP) );
        
        buildKeyboardPanel();
    }//end constructor
    
    /**
     The buildKeyboardPanel method builds and adds buttons and JLabels.
    */
    
    public void buildKeyboardPanel()
    {
        smallSpacer = new JLabel("");
        smallSpacer.setPreferredSize( new Dimension(WIDTH1, HEIGHT) );
        mediumSpacer = new JLabel("");
        mediumSpacer.setPreferredSize( new Dimension(WIDTH3, HEIGHT) );
        largeSpacer = new JLabel("");
        largeSpacer.setPreferredSize( new Dimension(WIDTH6, HEIGHT) );
                
        //create buttons and add to an arraylist
        String[] buttonNames = {"~", "1", "2", "3", "4", "5", "6", "7", "8","9",
            "0", "-", "=", "Backspace", "Tab", "Q", "W", "E", "R", "T", "Y", 
            "U", "I", "O", "P", "[", "]", "\\", "Caps", "A", "S", "D", "F", "G",
            "H", "J", "K", "L", ";", "'", "Enter", "Shift", "Z", "X", "C", "V",
            "B", "N", "M", ",", ".", "?", "\u25b2", "", "\u25C4", "\u25bc", 
            "\u25ba"};
        int buttonIndex = 0;
        for(String name:buttonNames)
        {
            button = new JButton(name);
            button.setPreferredSize( new Dimension(WIDTH2, HEIGHT1) );
            buttons.add(buttonIndex, button);
            buttonIndex++;
        }
        //resize the bigger buttons (Backspace, Tab, Caps, Shift, Enter)
        buttons.get(13).setPreferredSize( new Dimension(WIDTH5, HEIGHT1) );
        buttons.get(14).setPreferredSize( new Dimension(WIDTH4, HEIGHT1) );
        buttons.get(28).setPreferredSize( new Dimension(WIDTH4, HEIGHT1) );
        buttons.get(40).setPreferredSize( new Dimension(WIDTH5, HEIGHT1) );
        buttons.get(41).setPreferredSize( new Dimension(WIDTH5, HEIGHT1) );
        //set the size of the button that represents the space bar
        buttons.get(53).setPreferredSize( new Dimension(WIDTH7, HEIGHT1) );
        
        //create row panels and add to an arraylist and then to the main panel
        for(int rowIndex = 0; rowIndex < 5; rowIndex++)
        {
            row = new JPanel();
            row.setLayout( new FlowLayout(FlowLayout.LEFT, HORIZONTAL_GAP,
                    VERTICAL_GAP) );
            rows.add(rowIndex, row);
            add(row);
        }
        
        //add buttons to their respective rows
        int buttonNumber;
        for(buttonNumber = 0; buttonNumber < 14; buttonNumber++)
            rows.get(0).add( buttons.get(buttonNumber) );
        for(buttonNumber = 14; buttonNumber < 28; buttonNumber++) 
            rows.get(1).add( buttons.get(buttonNumber) );
        for(buttonNumber = 28; buttonNumber < 41; buttonNumber++)
            rows.get(2).add( buttons.get(buttonNumber) );
        
        for(buttonNumber = 41; buttonNumber < 52; buttonNumber++)
            rows.get(3).add( buttons.get(buttonNumber) );
        rows.get(3).add(smallSpacer);
        rows.get(3).add( buttons.get(52) );
        
        rows.get(4).add(largeSpacer);
        rows.get(4).add( buttons.get(53) );
        rows.get(4).add(mediumSpacer);
        for(buttonNumber = 54; buttonNumber < buttons.size(); buttonNumber++)
            rows.get(4).add( buttons.get(buttonNumber) );
    }
    
    /**
       The highlight method receives a key code and calls the setHighlight 
       method for the corresponding button after calling the setLowlight method
       for the button previously previously highlighted.
       @param currentKey the key code corresponding to the key that is typed
    */
    
    public void highlight(int currentKey)
    {
        //remove highlight from previously pressed key 
        switch(previousKey)
        {
            case KeyEvent.VK_BACK_QUOTE:
                setLowlight( buttons.get(0) );
                break;
                
            case KeyEvent.VK_1:
                setLowlight( buttons.get(1) );
                break;
                
            case KeyEvent.VK_2:
                setLowlight( buttons.get(2) );
                break;
                
            case KeyEvent.VK_3:
                setLowlight( buttons.get(3) );
                break;
            
            case KeyEvent.VK_4:
                setLowlight( buttons.get(4) );
                break;
                
            case KeyEvent.VK_5:
                setLowlight( buttons.get(5) );
                break;
            
            case KeyEvent.VK_6:
                setLowlight( buttons.get(6) );
                break;
                
            case KeyEvent.VK_7:
                setLowlight( buttons.get(7) );
                break;
                
            case KeyEvent.VK_8:
                setLowlight( buttons.get(8) );
                break;
                
            case KeyEvent.VK_9:
                setLowlight( buttons.get(9) );
                break;
                
             case KeyEvent.VK_0:
                setLowlight( buttons.get(10) );
                break;
                
            case KeyEvent.VK_MINUS:
                setLowlight( buttons.get(11) );
                break;
                
            case KeyEvent.VK_EQUALS:
                setLowlight( buttons.get(12) );
                break;
             
            case KeyEvent.VK_BACK_SPACE:
                setLowlight( buttons.get(13) );
                break;
            
            case KeyEvent.VK_TAB:
                setLowlight( buttons.get(14) );
                break;
                
            case KeyEvent.VK_Q:
                setLowlight( buttons.get(15) );
                break;
                
            case KeyEvent.VK_W:
                setLowlight( buttons.get(16) );
                break;
                
            case KeyEvent.VK_E:
                setLowlight( buttons.get(17) );
                break;
                
            case KeyEvent.VK_R:
                setLowlight( buttons.get(18) );
                break;
                
            case KeyEvent.VK_T:
                setLowlight( buttons.get(19) );
                break;
                
            case KeyEvent.VK_Y:
                setLowlight( buttons.get(20) );
                break;
                
            case KeyEvent.VK_U:
                setLowlight( buttons.get(21) );
                break;
                
            case KeyEvent.VK_I:
                setLowlight( buttons.get(22) );
                break;
                
            case KeyEvent.VK_O:
                setLowlight( buttons.get(23) );
                break;
                
            case KeyEvent.VK_P:
                setLowlight( buttons.get(24) );
                break;
                
            case KeyEvent.VK_OPEN_BRACKET:
                setLowlight( buttons.get(25) );
                break;
                
            case KeyEvent.VK_CLOSE_BRACKET:
                setLowlight( buttons.get(26) );
                break;
                
            case KeyEvent.VK_BACK_SLASH:
                setLowlight( buttons.get(27) );
                break;
                         
            case KeyEvent.VK_CAPS_LOCK:
                setLowlight( buttons.get(28) );
                break;
                
            case KeyEvent.VK_A:
                setLowlight( buttons.get(29) );
                break;
                
            case KeyEvent.VK_S:
                setLowlight( buttons.get(30) );
                break;
                
            case KeyEvent.VK_D:
                setLowlight( buttons.get(31) );
                break;
                
            case KeyEvent.VK_F:
                setLowlight( buttons.get(32) );
                break;
                
            case KeyEvent.VK_G:
                setLowlight( buttons.get(33) );
                break;
                
            case KeyEvent.VK_H:
                setLowlight( buttons.get(34) );
                break;
                
            case KeyEvent.VK_J:
                setLowlight( buttons.get(35) );
                break;
                
            case KeyEvent.VK_K:
                setLowlight( buttons.get(36) );
                break;
                
            case KeyEvent.VK_L:
                setLowlight( buttons.get(37) );
                break;
                
            case KeyEvent.VK_SEMICOLON:
                setLowlight( buttons.get(38) );
                break;
                
            case KeyEvent.VK_QUOTE:
                setLowlight( buttons.get(39) );
                break;
                
            case KeyEvent.VK_ENTER:
                setLowlight( buttons.get(40) );
                break;
                
            case KeyEvent.VK_SHIFT:
                setLowlight( buttons.get(41) );
                break;
                
            case KeyEvent.VK_Z:
                setLowlight( buttons.get(42) );
                break;
                
            case KeyEvent.VK_X:
                setLowlight( buttons.get(43) );
                break;
                
            case KeyEvent.VK_C:
                setLowlight( buttons.get(44) );
                break;
                
            case KeyEvent.VK_V:
                setLowlight( buttons.get(45) );
                break;
                
            case KeyEvent.VK_B:
                setLowlight( buttons.get(46) );
                break;
                
            case KeyEvent.VK_N:
                setLowlight( buttons.get(47) );
                break;
                
            case KeyEvent.VK_M:
                setLowlight( buttons.get(48) );
                break;
                
             case KeyEvent.VK_COMMA:
                setLowlight( buttons.get(49) );
                break;
                
            case KeyEvent.VK_PERIOD:
                setLowlight( buttons.get(50) );
                break;
                
            case KeyEvent.VK_SLASH:
                setLowlight( buttons.get(51) );
                break;
                
            case KeyEvent.VK_UP:
                setLowlight( buttons.get(52) );
                break;
              
            case KeyEvent.VK_SPACE:
                setLowlight( buttons.get(53) );
                break;
                
            case KeyEvent.VK_LEFT:
                setLowlight( buttons.get(54) );
                break;
                
            case KeyEvent.VK_DOWN:
                setLowlight( buttons.get(55) );
                break;
                
            case KeyEvent.VK_RIGHT:
                setLowlight( buttons.get(56) );
                break;
                
            default:
                System.out.println("No previously highlighted key");
                break;
        }//end switch setLowlight
        
        //highlight currently typed key
        switch(currentKey)
        {
            case KeyEvent.VK_BACK_QUOTE:
                setHighlight( buttons.get(0) );
                break;
                
            case KeyEvent.VK_1:
                setHighlight( buttons.get(1) );
                break;
                
            case KeyEvent.VK_2:
                setHighlight( buttons.get(2) );
                break;
                
            case KeyEvent.VK_3:
                setHighlight( buttons.get(3) );
                break;
            
            case KeyEvent.VK_4:
                setHighlight( buttons.get(4) );
                break;
                
            case KeyEvent.VK_5:
                setHighlight( buttons.get(5) );
                break;
            
            case KeyEvent.VK_6:
                setHighlight( buttons.get(6) );
                break;
                
            case KeyEvent.VK_7:
                setHighlight( buttons.get(7) );
                break;
                
            case KeyEvent.VK_8:
                setHighlight( buttons.get(8) );
                break;
                
            case KeyEvent.VK_9:
                setHighlight( buttons.get(9) );
                break;
                
             case KeyEvent.VK_0:
                setHighlight( buttons.get(10) );
                break;
                
            case KeyEvent.VK_MINUS:
                setHighlight( buttons.get(11) );
                break;
                
            case KeyEvent.VK_EQUALS:
                setHighlight( buttons.get(12) );
                break;
             
            case KeyEvent.VK_BACK_SPACE:
                setHighlight( buttons.get(13) );
                break;
            
            case KeyEvent.VK_TAB:
                setHighlight( buttons.get(14) );
                break;
                
            case KeyEvent.VK_Q:
                setHighlight( buttons.get(15) );
                break;
                
            case KeyEvent.VK_W:
                setHighlight( buttons.get(16) );
                break;
                
            case KeyEvent.VK_E:
                setHighlight( buttons.get(17) );
                break;
                
            case KeyEvent.VK_R:
                setHighlight( buttons.get(18) );
                break;
                
            case KeyEvent.VK_T:
                setHighlight( buttons.get(19) );
                break;
                
            case KeyEvent.VK_Y:
                setHighlight( buttons.get(20) );
                break;
                
            case KeyEvent.VK_U:
                setHighlight( buttons.get(21) );
                break;
                
            case KeyEvent.VK_I:
                setHighlight( buttons.get(22) );
                break;
                
            case KeyEvent.VK_O:
                setHighlight( buttons.get(23) );
                break;
                
            case KeyEvent.VK_P:
                setHighlight( buttons.get(24) );
                break;
                
            case KeyEvent.VK_OPEN_BRACKET:
                setHighlight( buttons.get(25) );
                break;
                
            case KeyEvent.VK_CLOSE_BRACKET:
                setHighlight( buttons.get(26) );
                break;
                
            case KeyEvent.VK_BACK_SLASH:
                setHighlight( buttons.get(27) );
                break;    
               
            case KeyEvent.VK_CAPS_LOCK:
                setHighlight( buttons.get(28) );
                break;
                
            case KeyEvent.VK_A:
                setHighlight( buttons.get(29) );
                break;
                
            case KeyEvent.VK_S:
                setHighlight( buttons.get(30) );
                break;
                
            case KeyEvent.VK_D:
                setHighlight( buttons.get(31) );
                break;
                
            case KeyEvent.VK_F:
                setHighlight( buttons.get(32) );
                break;
                
            case KeyEvent.VK_G:
                setHighlight( buttons.get(33) );
                break;
                
            case KeyEvent.VK_H:
                setHighlight( buttons.get(34) );
                break;
                
            case KeyEvent.VK_J:
                setHighlight( buttons.get(35) );
                break;
                
            case KeyEvent.VK_K:
                setHighlight( buttons.get(36) );
                break;
                
            case KeyEvent.VK_L:
                setHighlight( buttons.get(37) );
                break;
                
            case KeyEvent.VK_SEMICOLON:
                setHighlight( buttons.get(38) );
                break;
                
            case KeyEvent.VK_QUOTE:
                setHighlight( buttons.get(39) );
                break;
                
            case KeyEvent.VK_ENTER:
                setHighlight( buttons.get(40) );
                break;
                
            case KeyEvent.VK_SHIFT:
                setHighlight( buttons.get(41) );
                break;
                
            case KeyEvent.VK_Z:
                setHighlight( buttons.get(42) );
                break;
                
            case KeyEvent.VK_X:
                setHighlight( buttons.get(43) );
                break;
                
            case KeyEvent.VK_C:
                setHighlight( buttons.get(44) );
                break;
                
            case KeyEvent.VK_V:
                setHighlight( buttons.get(45) );
                break;
                
            case KeyEvent.VK_B:
                setHighlight( buttons.get(46) );
                break;
                
            case KeyEvent.VK_N:
                setHighlight( buttons.get(47) );
                break;
                
            case KeyEvent.VK_M:
                setHighlight( buttons.get(48) );
                break;
                
             case KeyEvent.VK_COMMA:
                setHighlight( buttons.get(49) );
                break;
                
            case KeyEvent.VK_PERIOD:
                setHighlight( buttons.get(50) );
                break;
                
            case KeyEvent.VK_SLASH:
                setHighlight( buttons.get(51) );
                break;
                
            case KeyEvent.VK_UP:
                setHighlight( buttons.get(52) );
                break;
              
            case KeyEvent.VK_SPACE:
                setHighlight( buttons.get(53) );
                break;
                
            case KeyEvent.VK_LEFT:
                setHighlight( buttons.get(54) );
                break;
                
            case KeyEvent.VK_DOWN:
                setHighlight( buttons.get(55) );
                break;
                
            case KeyEvent.VK_RIGHT:
                setHighlight( buttons.get(56) );
                break;
                
            default:
                System.out.println("Try a different key");
                break;
        }//end switch setHighlight
         
        //pass the key code of the current key to the previousKey variable
        previousKey = currentKey;
    }//end highlight method
    
    /**
       The setHighlight method sets the button background and font color. 
       @param buttonToHighlight the JButton to highlight
    */
    
    public void setHighlight(JButton buttonToHighlight)
    {
        buttonToHighlight.setBackground(Color.GRAY);
        buttonToHighlight.setForeground(Color.WHITE);
    }
    
    /**
       The setLowlight method sets the button background and font back to 
       default colors.
       @param buttonToLowlight the JButton to return to default colors
    */
    
    public void setLowlight(JButton buttonToLowlight)
    {
        buttonToLowlight.setBackground(null);
        buttonToLowlight.setForeground(null);
    }
}//end KeyboardPanel class
