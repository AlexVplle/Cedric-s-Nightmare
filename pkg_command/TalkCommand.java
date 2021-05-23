package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "talk"
 */
public class TalkCommand extends Command
{
    /**
     * Constructor for TalkCommand
     */
    public TalkCommand()
    {
        
    } //TalkCommand()
    
    /**
     * command executed when the player type "talk"
     * @param pEngine GameEngine
     */
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            String vSecondWord = this.getSecondWord();
            pEngine.getPlayer().talk(vSecondWord);
        }
        else{
            pEngine.getGui().println("Who do you want to talk to ?\n");
        }
    } //execute()
} //TalkCommand