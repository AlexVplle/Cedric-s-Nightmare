package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * this class is used when the player type "test"
 */
public class TestCommand extends Command
{
    /**
     * Constructor for TestCommand
     */
    public TestCommand()
    {
        
    } //TestCommand()
    
    /**
     * command executed when the player type "test"
     * @param pEngine GameEngine
     */    
    public void execute(final GameEngine pEngine)
    {
        if (this.hasSecondWord()){
            if (this.getSecondWord().equals("on")){
                if (pEngine.getTest()){
                    pEngine.getGui().println("You are already in the testing phase.\n");
                }
                else{
                    pEngine.setTest(true);
                    pEngine.getGui().println("You are now in the testing phase.\n");
                }
            }
            else if (this.getSecondWord().equals("off")){
                if (!pEngine.getTest()){
                    pEngine.getGui().println("You are not already in the testing phase.\n");
                }
                else{
                    pEngine.setTest(false);
                    pEngine.getGui().println("You are quitted the testing phase.\n");
                }
            }
            else{
                pEngine.test(this.getSecondWord());
            }
        }
        else{
            pEngine.getGui().println("What do you want to test ?\n");
        }
    } //execute(.)
} //TestCommand