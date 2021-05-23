package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "look"
 */
public class LookCommand extends Command
{
    /**
     * Constructor for LookCommand
     */
    public LookCommand()
    {
        
    } //InventoryCommand()
    
    /**
     * command executed when the player type "look"
     * @param pEngine GameEngine
     */    
    public void execute(GameEngine pEngine)
    {
        String vSecondWord = this.getSecondWord();
        pEngine.look(vSecondWord);
    } //execute(.)
} //LookCommand