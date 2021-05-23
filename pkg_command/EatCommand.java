package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "eat"
 */
public class EatCommand extends Command
{
    /**
     * Constructor for EatCommand
     */
    public EatCommand()
    {
        
    } //EatCommand()
    
    /**
     * command executed when the player type "eat"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            String vSecondWord = this.getSecondWord();
            pEngine.getPlayer().eat(vSecondWord);
        }
        else{
            pEngine.getGui().println("What do you want to eat ?\n");
        }
    } //execute(.)
} //EatCommand