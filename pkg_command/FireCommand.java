package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "fire"
 */
public class FireCommand extends Command
{
    /**
     * Constructor for FireCommand
     */
    public FireCommand()
    {
        
    } //FireCommand()
    
    /**
     * command executed when the player type "eat"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            pEngine.getGui().println("Just type \"fire\"\n");
        }
        else{
            pEngine.fire();
        }
    } //execute(.)
} //FireCommand