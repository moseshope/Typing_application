/*
   Khanh Do
   CIS 2151 – Prof. John P. Baugh
   Summer 2016
   Programming Assignment 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The TypingApplication program displays a keyboard on the screen.  When the  
   user hits a key on the physical keyboard, it will highlight the corresponding   
   button on the virtual keyboard.
   @author Khanh Do
   @version July 27, 2016
*/

public class TypingApplication extends JFrame
{
    private final int WINDOW_WIDTH = 820;
    private final int WINDOW_HEIGHT = 640;
    private final int TEXT_ROWS = 5;
    private final int TEXT_COLUMNS = 50;
    private final int EDGE = 10;
        
    private JPanel text;        //a panel containing instructions and text area
    private LabelsPanel labels;  //a panel containing instructions
    private JTextArea output;   //a multi-line text for user input
    private KeyboardPanel keys; //a panel containing buttons representing keys
    
    /**
       The constructor builds the virtual keyboard and displays it on the 
       screen.  
     */
    
    public TypingApplication()
    {
        setTitle("Typing Application");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new GridLayout(2, 1) );
        
        buildKeyboard();
        
        add(text);
        add(keys);
        //pack();                               //looks better without pack()
        setVisible(true);
    }
    
    /**
       The buildKeyboard method creates a label panel, a keyboard panel, and a
       text area for the virtual keyboard.
    */
    
    public void buildKeyboard()
    {
        labels = new LabelsPanel();
        output = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBorder( BorderFactory.createLineBorder(Color.BLUE, 1, true) );
        output.addKeyListener( new KeyHandler() );
                
        text = new JPanel();
        text.setLayout( new BorderLayout() );
        text.add(labels, BorderLayout.NORTH);
        text.add(output, BorderLayout.CENTER);
        text.setBorder( BorderFactory.createEmptyBorder(EDGE, EDGE, EDGE, 
                EDGE) );
        
        keys = new KeyboardPanel();
        keys.setBorder( BorderFactory.createEmptyBorder(EDGE, EDGE, EDGE, 
                EDGE) );
    }
    
    /**
       The KeyHandler class handles the event that is generated when the user 
       types on the physical keyboard.  Its keyPressed method passes the 
       corresponding key code of the key typed to the highlight method, which it 
       calls.  The methods keyTyped and keyReleased are not used, but must be 
       included in this interface.
    */
    
    private class KeyHandler implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
        //did not need this method
        }
        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            keys.highlight(keyCode);
        }
        @Override
        public void keyReleased(KeyEvent e)
        {
        //did not need this method
        }
    }//end KeyHandler class
    
    /**
       The main method creates an instance of the TypingApplication class, which
       causes it to display a keyboard in its window.
    */
    
    public static void main(String[] args)
    {
        new TypingApplication();
    }//end main
}

