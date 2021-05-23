package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "quit"
 */
public class QuitCommand extends Command
{
    /**
     * Constructor for QuitCommand
     */
    public QuitCommand()
    {
        
    } //QuitCommand()
    
    /**
     * command executed when the player type "quit"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
         if (this.hasSecondWord()){
             pEngine.getGui().println("Quit what?\n");
         }
         else{
             pEngine.endGame();
         }
    } //execute(.)
}//QuitCommand