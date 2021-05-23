package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "inventory"
 */
public class InventoryCommand extends Command
{
    /**
     * Constructor for InventoryCommand
     */
    public InventoryCommand()
    {
        
    } //InventoryCommand()
    
    /**
     * command executed when the player type "help"
     * @param pEngine GameEngine
     */
    public void execute(GameEngine pEngine)
    {
        pEngine.getGui().println(pEngine.getPlayer().items());
    } //execute(.)
} //InventoryCommand