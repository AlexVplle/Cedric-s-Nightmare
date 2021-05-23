package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "go"
 */
public class GoCommand extends Command
{
    /**
     * Constructor for FireCommand
     */
    public GoCommand()
    {
        
    } //FireCommand()
    
    /**
     * command executed when the player type "go"
     * @param pEngine GameEngine
     */    
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            String vDirection = this.getSecondWord().toLowerCase();
            pEngine.goRoom(vDirection);
        }
        else{
            pEngine.getGui().println("Go where ?\n");
        }
    } //execute(.)
} //GoCommand