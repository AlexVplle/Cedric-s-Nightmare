package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "drop"
 */
public class DropCommand extends Command
{
    
    /**
     * Constructor for ChargeCommand
     */
    public DropCommand()
    {
        
    } //DropCommand()
    
    /**
     * command executed when the player type "charge"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            pEngine.getPlayer().drop(this.getSecondWord());
        }
        else{
            pEngine.getGui().println("What do you want to drop ?\n");
        }
    } //execute(.)
} //DropCommand