package pkg_command;

import java.util.HashMap;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes
 * @author Alexis Vapaille
 * @version 2011.07.31
 * @version 2021.04.29
 */
public class CommandWords
{
    /**
     * private HashMap with String as keys and Command as value
     */
    private HashMap<String, Command> aCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aCommands = new HashMap<String, Command>();
        this.aCommands.put("go", new GoCommand());
        this.aCommands.put("look", new LookCommand());
        this.aCommands.put("inventory", new InventoryCommand());
        this.aCommands.put("back", new BackCommand());
        this.aCommands.put("help", new HelpCommand());
        this.aCommands.put("eat", new EatCommand());
        this.aCommands.put("take", new TakeCommand());
        this.aCommands.put("drop", new DropCommand());
        this.aCommands.put("test", new TestCommand());
        this.aCommands.put("fire", new FireCommand());
        this.aCommands.put("charge", new ChargeCommand());
        this.aCommands.put("alea", new AleaCommand());
        this.aCommands.put("talk", new TalkCommand());
        this.aCommands.put("quit", new QuitCommand());
    } //CommandWords

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     * @param pWord String to retrieve the command associated to the String
     * @return Command associated to the given String
     */
    public Command get(String pWord)
    {
        return (Command) this.aCommands.get(pWord);
    } //get(.)

    /**
     * print all valid commands
     * @return String with all command words
     */
    public StringBuilder getCommandList()
    {
        StringBuilder vAllCommands = new StringBuilder();
        for(String vCommand : this.aCommands.keySet()){
            vAllCommands.append(vCommand + " ");
        }
        return vAllCommands;
    } //getCommandList()
} // CommandWord