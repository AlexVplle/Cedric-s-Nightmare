package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "help"
 */
public class HelpCommand extends Command
{
    /**
     * Constructor for HelpCommand
     */
    public HelpCommand()
    {
        
    } //HelpCommand()
    
    /**
     * command executed when the player type "help"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            pEngine.getGui().println("Just type \"help\"\n");
        }
        else{
            pEngine.printHelp();
        }
    } //execute(.)
} //HelpCommand