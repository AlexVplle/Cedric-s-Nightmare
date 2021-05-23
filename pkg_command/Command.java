package pkg_command;

import pkg_skeleton.GameEngine;

/**
 * This class is an abstract superclass for all command classes in the game.
 * Each user command is implemented by a specific command subclass.
 *
 * Objects of class Command can store an optional argument word (a second
 * word entered on the command line). If the command had only one word, 
 * then the second word is null.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */

public abstract class Command
{
    /**
     * private String containing the second word
     */
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        secondWord = null;
    } //Command()

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     * @return String containing the second word
     */
    public String getSecondWord()
    {
        return secondWord;
    } //getSecondWord()

    /**
     * Check whether a second word was entered for this 
     * command.
     * @return boolean to know if there is a second word
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    } //hasSecondWord()

    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     * @param secondWord String replacing the previous second word
     */
    public void setSecondWord(String pSecondWord)
    {
        this.secondWord = pSecondWord;
    } //setSecondWord(.)

    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * @param pEngine GameEngine
     */
    public abstract void execute(GameEngine pEngine);
} //Command

