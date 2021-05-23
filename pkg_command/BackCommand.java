package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "back"
 */
public class BackCommand extends Command
{
    /**
     * Constructor for BackCommand
     */
    public BackCommand()
    {

    } //BackCommand()
    
    /**
     * command executed when the player type "back"
     * @param pEngine GameEngine
     */
    public void execute(GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            pEngine.getGui().println("Just type \"back\"\n");
        }
        else{
            pEngine.back();
        }
    } //execute(.)
} //BackCommand