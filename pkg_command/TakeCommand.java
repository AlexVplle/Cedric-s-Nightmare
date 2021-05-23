package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "take"
 */
public class TakeCommand extends Command
{
    /**
     * Constructor for TakeCommand
     */
    public TakeCommand()
    {
        
    } //TakeCommand()
    
    /**
     * command executed when the player type "take"
     * @param pEngine GameEngine
     */    
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            String vSecondWord = this.getSecondWord();
            pEngine.getPlayer().take(vSecondWord);
        }
        else{
            pEngine.getGui().println("What do you want to take ?\n");
        }
    } //execute(.)
} //TakeCommand