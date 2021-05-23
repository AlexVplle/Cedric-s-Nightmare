package pkg_skeleton;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003) DB edited (2019)
 */
public class UserInterface implements ActionListener
{
    // ### Attributes ###
    
    /**
     * private Game Engine
     */
    private GameEngine aEngine;
    
    /**
     * private JFrame
     */
    private JFrame aMyFrame;
    
    /**
     * private JTextField
     */
    private JTextField aEntryField;
    
    /**
     * private JTextArea
     */
    private JTextArea aLog;
    
    /**
     * private Jlabel for show the image
     */
    private JLabel aImage;
    
    /**
     * private JButton
     */
    private JButton aNorthButton;
    
    /**
     * private JButton
     */
    private JButton aEastButton;
    
    /**
     * private JButton
     */
    private JButton aSouthButton;
    
    /**
     * private JButton
     */
    private JButton aWestButton;
    
    /**
     * private JButton
     */
    private JButton aUpButton;
    
    /**
     * private JButton
     */
    private JButton aDownButton;
    
    /**
     * private int remaining time
     */
    private int     aTimerTime;
    
    /**
     * private Timer
     */
    private Timer   aTimer;
    
    // ### Constructor ###
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(final GameEngine pGameEngine)
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)
    
    /**
     * Assessor for Game Engine
     * @return Game Engine
     */
    public GameEngine getEngine()
    {
        return this.aEngine;
    } //getEngine()
    
    /**
     * Print out some text into the text area.
     * @param pText print text in the text area
     */
    public void print(final String pText)
    {
        this.aLog.append(pText);
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength());
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText print text in the text area followed by a line break
     */
    public void println(final String pText)
    {
        this.print(pText + "\n");
    } // println(.)

    /**
     * Show an image file in the interface.
     * @param pImageName Image's name for his display
     */
    public void showImage(final String pImageName)
    {
        String vImagePath = "Images/" + pImageName + ".jpg"; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource(vImagePath);
        if (vImageURL == null)
            System.out.println("Image not found : " + vImagePath);
        else {
            ImageIcon vIcon = new ImageIcon(vImageURL);
            this.aImage.setIcon(vIcon);
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field and the timer.
     * @param pOnOff boolean to know if enable or disable
     */
    public void enable(final boolean pOnOff)
    {
        this.aEntryField.setEditable(pOnOff); // enable/disable
        this.aNorthButton.setEnabled(pOnOff);
        this.aEastButton.setEnabled(pOnOff);
        this.aSouthButton.setEnabled(pOnOff);
        this.aWestButton.setEnabled(pOnOff);
        this.aUpButton.setEnabled(pOnOff);
        this.aDownButton.setEnabled(pOnOff);
        this.aTimer.stop();
        if (!pOnOff){ // disable
            this.aEntryField.getCaret().setBlinkRate(0); // cursor won't blink
            this.aEntryField.removeActionListener(this); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame         = new JFrame("The Cedric's nightmare"); // change the title
        this.aEntryField      = new JTextField(34);
        this.aNorthButton     = new JButton("North");
        this.aEastButton      = new JButton("East");
        this.aSouthButton     = new JButton("South");
        this.aWestButton      = new JButton("West");
        this.aUpButton        = new JButton("Up");
        this.aDownButton      = new JButton("Down");
        
        this.aMyFrame.setResizable(false);
        
        JPanel vFloorLabel    = new JPanel();
        vFloorLabel.setLayout(new BorderLayout());
        vFloorLabel.add(this.aNorthButton, BorderLayout.NORTH);
        vFloorLabel.add(this.aSouthButton, BorderLayout.SOUTH);
        
        JPanel vMove          = new JPanel();
        vMove.setLayout(new BorderLayout());
        vMove.add(this.aUpButton, BorderLayout.NORTH);
        vMove.add(this.aEastButton, BorderLayout.EAST);
        vMove.add(this.aDownButton, BorderLayout.SOUTH);
        vMove.add(this.aWestButton, BorderLayout.WEST);
        vMove.add(vFloorLabel, BorderLayout.CENTER);
        
        this.aTimerTime = 600;
         
        JLabel vTimerArea  = new JLabel();
        vTimerArea.setPreferredSize(new Dimension(200, 200));
        vTimerArea.setHorizontalAlignment(vTimerArea.CENTER);
        vTimerArea.setVerticalAlignment(vTimerArea.CENTER);
        
        this.aTimer        = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    if (aTimerTime != -1){
                        vTimerArea.setText("" + (aTimerTime / 60) + " : " + (aTimerTime % 60));
                        aTimerTime -= 1;
                    }
                    else{
                        aEngine.timeIsUp();
                    }
                }
            }
        );
        
        this.aTimer.start();
        
        this.aLog = new JTextArea();
        this.aLog.setEditable(false);
        JScrollPane vListScroller = new JScrollPane(this.aLog);
        vListScroller.setPreferredSize(new Dimension(200, 200));
        vListScroller.setMinimumSize(new Dimension(100,100));

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();

        vPanel.setLayout(new BorderLayout()); // ==> only five places
        vPanel.add(this.aImage, BorderLayout.NORTH);
        vPanel.add(vListScroller, BorderLayout.CENTER);
        vPanel.add(this.aEntryField, BorderLayout.SOUTH);
        vPanel.add(vTimerArea, BorderLayout.WEST);
        vPanel.add(vMove, BorderLayout.EAST);
        this.aMyFrame.getContentPane().add(vPanel, BorderLayout.CENTER);

        // add some event listeners to some components
        this.aEntryField.addActionListener(this);
        this.aNorthButton.addActionListener(this);
        this.aEastButton.addActionListener(this);
        this.aSouthButton.addActionListener(this);
        this.aWestButton.addActionListener(this);
        this.aUpButton.addActionListener(this);
        this.aDownButton.addActionListener(this);
        
        // to end program when window is closed
        this.aMyFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible(true);
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(final ActionEvent pE) 
    {
        if (pE.getActionCommand().equals("North")){
            this.aEngine.interpretCommand("go north");
        }
        else if (pE.getActionCommand().equals("East")){
            this.aEngine.interpretCommand("go east");
        }
        else if (pE.getActionCommand().equals("South")){
            this.aEngine.interpretCommand("go south");
        }
        else if (pE.getActionCommand().equals("West")){
            this.aEngine.interpretCommand("go west");
        }
        else if (pE.getActionCommand().equals("Up")){
            this.aEngine.interpretCommand("go up");
        }
        else if (pE.getActionCommand().equals("Down")){
            this.aEngine.interpretCommand("go down");
        }
        else{
            this.processCommand(); // never suppress this line
        }
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");
        this.aEngine.interpretCommand(vInput);
    } // processCommand()
} //UserInterface 
