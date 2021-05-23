package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "alea"
 */
public class AleaCommand extends Command
{
    /**
     * Constructor for AleaCommand
     */
    public AleaCommand()
    {
        
    } //AleaCommand()
    
    /**
     * command executed when the player type "alea"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (pEngine.getTest()){
            if (this.hasSecondWord()){
                pEngine.alea(this.getSecondWord());
            }
            else{
                if (pEngine.getSavedRoom() == null){
                    pEngine.getGui().println("Which room do you want to save ?\n" + pEngine.getRoomString() + "\n");
                }
                else
                {
                    pEngine.setSavedRoom(null);
                    pEngine.getGui().println("You have rediscovered the chance.\n");
                }
            }
        }
        else{
            pEngine.getGui().println("it has no effect.\n");
        }
    } //execute(.)
} //AleaCommand