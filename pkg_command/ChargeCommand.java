package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "charge"
 */
public class ChargeCommand extends Command
{
    
    /**
     * Constructor for ChargeCommand
     */
    public ChargeCommand()
    {
        
    } //ChargeCommand()
    
    /**
     * command executed when the player type "charge"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
         if (this.hasSecondWord()){
             pEngine.getGui().println("Just type \"charge\"\n");
         }
         else{
             pEngine.charge();
         }
    } //execute(.)
} //ChargeCommand